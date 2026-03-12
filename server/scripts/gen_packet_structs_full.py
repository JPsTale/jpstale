#!/usr/bin/env python3
"""
从 packets.h（及 shared 下其他头文件）解析 struct Packet* 的字段，生成带完整字段、readBody、writeBody 的 Java 类。
字符串型 char[] 映射为 String；其他类型按 C 布局映射。
用法: python3 gen_packet_structs_full.py [path/to/packets.h] [output/dir]
      若仅传一个参数则为 output 目录；不传则用默认 packets.h 与 output。
"""
import re
import os
import sys

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
SERVER_DIR = os.path.normpath(os.path.join(SCRIPT_DIR, ".."))
DEFAULT_H = os.path.normpath(os.path.join(SERVER_DIR, "../PristonTale-EU-main/shared/packets.h"))
DEFAULT_OUT = os.path.join(SERVER_DIR, "pt-common/src/main/java/org/jpstale/server/common/protocol/struct")

# 除 packets.h 外要合并解析的头文件（相对 shared 目录），用于发现 Packet* 定义
ADDITIONAL_HEADERS = [
    "unit.h", "skill.h", "quest.h", "item.h", "chat.h", "character.h",
    "Coin.h", "CStable.h", "map.h", "roll.h", "party.h",
]

SKIP_ALREADY = {"Packet"}

# C 字段名 -> Java 字段名覆盖（用于匈牙利命名导致的错误，如 NPC 被合并成 Npcquest）
JAVA_FIELD_NAME_OVERRIDES = {
    "bUpdateNPCQuestIcon": "updateNpcQuestIcon",
    "ePvPMapID": "pvpMapId",
}

# C 枚举类型 -> (Java 枚举类名, 字节数 1=byte/2=short/4=int)
# 对应 org.jpstale.server.common.enums 包中的枚举
C_ENUM_TO_JAVA = {
    "EAttackState": ("AttackState", 2),
    "EAttackProperty": ("AttackProperty", 2),
    "EFuryArenaState": ("FuryArenaState", 4),
    "EItemRarity": ("ItemRarity", 4),
    "EPhoenixType": ("PhoenixType", 4),
    "EItemFlag": ("ItemFlag", 4),
    "EDamageTextType": ("DamageTextType", 2),
    "EItemTimerType": ("ItemTimerType", 4),
    "EItemID": ("ItemId", 4),
    "EPvPKillType": ("PvPKillType", 4),
    "ELogCheat": ("LogCheat", 4),
    # 补充：packet 中常见枚举
    "EChatColor": ("ChatColor", 4),
    "EMapID": ("MapId", 4),
    "EQuestPartyType": ("QuestPartyType", 1),
    "EQuestType": ("QuestType", 1),
    "EQuestExtraRewardType": ("QuestExtraRewardType", 4),
    "EAsmQuestBit": ("AsmQuestBit", 4),
    "EItemSource": ("ItemSource", 1),
    "EQuestStatus": ("QuestStatus", 4),
    "ESlotTypeHandle": ("SlotTypeHandle", 4),
    "ESlotTypeHandleWhere": ("SlotTypeHandleWhere", 4),
    "EIntegrityUpdate": ("IntegrityUpdate", 1),
    "EPartyState": ("PartyState", 4),
    "ERaidState": ("RaidState", 4),
    "ECharacterClass": ("CharacterClass", 4),
    "ESkillID": ("SkillId", 4),
}

# 宏常量替换（用于数组长度）
MACROS = {
    "CRASHDATA_SIZE": "0x1F00",
    "MIXLIST_FUNCTION_TOTAL": "70",
    "MAX_MAP_INDICATORS": "30",
    "EASTER_ITEMS_MAX": "3",
    "PUZZLE_ITEMS_MAX": "3",
    "DAMAGEDEBUGCONTAINER_LENGTH": "0x1FF6",
    "MAX_SKILL_ARRAY_DATA": "150",
    "MAX_COMMON_SKILL_INFO_DATA": "25",
    "SKILL_COUNT_CHARACTER": "16",
    "CHECKSUM_FUNCTION_TOTAL": "400",
    "WINDOW_CHEATLIST_TOTAL": "50",
    "MAX_TOP_DAMAGEDATA": "10",
    "MAX_DAMAGEDATA": "100",
    "MAX_BLESSCASTLE_CLANCROWN": "3",
    "MAX_AGINGRECOVERY_PER_PACKET": "10",
    "MAX_QUEST_INFO": "88",
    "MAX_QUESTDYNAMICMENU": "50",
    "MAX_SPAWN_MARKERS": "200",
    "MAX_PARTY_MEMBERS": "6",
    "MAX_RAID": "2",
    "QUEST_MONSTERITEM_MAX": "5",
    "MAX_QUESTEXTRAREWARD_COUNT": "3",
    "MAX_QUESTREWARD_ITEM": "10",
    "MAX_PET_STABLE": "5",
    "MAX_QUESTPACKETDATA": "15",
}

# C 结构体类型（含别名）-> 字节数，用于计算 BODY_SIZE
STRUCT_BODY_SIZES = {
    "Point3D": 12,
    "BlessCastleStatusShort": 56,
    "ChecksumFunction": 12,
    "SkillInfoCommon": 250,
    "StructFuryArenaBoss": 8,
    "ItemUsing": 20,
    "_sTRANS_SERVER_INFO": 108,
    "TransServerInfo": 108,
    "StageItemData": 63,
    "SkillInfo": 314,
    "SkillArrayData": 48,
    "ElementalAttackSetting": 8,
    "Header": 36,
    "Server": 108,
    "SYSTEMTIME": 16,
    "SystemTime": 16,
    "PlayBufferData": 40,
    "DropItemData": 12,
    "MinMax": 4,
    "CharacterDataPacket": 40,
    "ItemPremium": 16,
    "PartyUserData": 196,
    "PartyUserInfo": 28,
    "MapIndicator": 20,
    "ItemListMix": 56,
    "ItemMixDesc": 32,
    "CurMax": 4,
    "IMinMax": 8,
    "_TRANS_CHAR_INFO": 240,
    "TransCharInfo": 240,
    # 补充：packet 中嵌套/数组用到的结构体
    "PacketSkillBuffStatus": 56,
    "QuestInformation": 92,
    "AgingRecoveryDataHandle": 56,
    "PartyMemberData": 26,
    "PartyRaidMemberData": 24,
    "PartyMember": 63,
    "PartyRaid": 337,
    "CStablePetTab": 222,
    "QuestData": 80,
    # 大型物品结构，按 Java 端包装类的 SIZE_OF 设置，供 Packet 中嵌套使用
    "ItemData": 0x4B4,
    "Item": 0x4C4,
}

# 有对应 Java 类且需 readFrom/writeTo 的结构体（标量+数组均在 map_type/field_size 中统一处理）
STRUCT_JAVA_CLASSES = frozenset({
    "Point3D", "BlessCastleStatusShort", "ChecksumFunction", "SkillInfoCommon", "StructFuryArenaBoss",
    "ItemUsing", "TransServerInfo", "StageItemData", "SkillInfo", "SkillArrayData", "ElementalAttackSetting",
    "Header", "Server", "SystemTime", "PlayBufferData", "DropItemData", "MinMax", "CharacterDataPacket",
    "ItemPremium", "PartyUserData", "PartyUserInfo", "MapIndicator", "ItemListMix", "ItemMixDesc",
    "CurMax", "IMinMax", "TransCharInfo",
    "PacketSkillBuffStatus", "QuestInformation", "AgingRecoveryDataHandle",
    "PartyMemberData", "PartyRaidMemberData", "PartyMember", "PartyRaid", "CStablePetTab",
    "ItemData", "Item", "QuestData",
})


def _enum_size(c_type: str) -> int:
    """C 枚举在 wire 上的字节数。"""
    if c_type not in C_ENUM_TO_JAVA:
        return 4
    _, size = C_ENUM_TO_JAVA[c_type]
    return size


def field_size_bytes(c_type: str, array_dims: list, is_string: bool, packet_body_sizes: dict = None) -> int:
    """单字段在 wire 上的字节数。与 map_type 的类型布局一致。"""
    packet_body_sizes = packet_body_sizes or {}
    # 字符串
    if is_string and c_type == "char" and array_dims:
        if len(array_dims) == 1:
            return array_dims[0]
        return array_dims[0] * array_dims[1]
    # 标量
    if not array_dims:
        if c_type in C_ENUM_TO_JAVA:
            return _enum_size(c_type)
        if c_type in ("Point3D", "Point"):
            return STRUCT_BODY_SIZES["Point3D"]
        if c_type in ("_TRANS_CHAR_INFO", "TransCharInfo"):
            return STRUCT_BODY_SIZES["TransCharInfo"]
        if c_type in STRUCT_BODY_SIZES:
            return STRUCT_BODY_SIZES[c_type]
        if c_type.startswith("Packet") and c_type != "Packet":
            return packet_body_sizes.get(c_type, 0)
        if c_type in ("INT64", "int64_t", "uint64_t", "long", "unsigned __int64"):
            return 8
        if c_type == "BOOL":
            return 4
        if c_type == "char":
            return 1
        if c_type in ("DWORD", "UINT", "int", "ID", "PVOID") or "int" in c_type.lower():
            return 4
        if c_type in ("WORD", "USHORT", "short"):
            return 2
        if c_type in ("BYTE", "byte"):
            return 1
        if c_type == "float":
            return 4
        if c_type == "bool":
            return 1
        return 4
    # 数组
    if len(array_dims) == 1:
        n = array_dims[0]
        if c_type in ("DWORD", "UINT", "int", "BOOL", "ID"):
            return 4 * n
        if c_type in ("WORD", "USHORT", "short"):
            return 2 * n
        if c_type in ("BYTE", "byte", "char"):
            return n
        if c_type == "float":
            return 4 * n
        if c_type in ("uint64_t", "INT64", "int64_t", "unsigned __int64"):
            return 8 * n
        if c_type in C_ENUM_TO_JAVA:
            return _enum_size(c_type) * n
        if c_type in STRUCT_BODY_SIZES:
            return STRUCT_BODY_SIZES[c_type] * n
        return 4 * n
    if len(array_dims) == 2:
        n1, n2 = array_dims[0], array_dims[1]
        if c_type == "int":
            return 4 * n1 * n2
        if c_type == "char":
            return n1 * n2
        if c_type in STRUCT_BODY_SIZES:
            return STRUCT_BODY_SIZES[c_type] * n1 * n2
        return n1 * n2
    return 0


def compute_body_size(fields: list, packet_body_sizes: dict = None) -> int:
    """对当前包体字段列表求和得到包体字节数。fields 元素为 (jtype, jname, read_code, write_code, array_dims, is_string, c_type, c_name, c_comment)。"""
    return sum(
        field_size_bytes(c_type, array_dims, is_string, packet_body_sizes)
        for (_, _, _, _, array_dims, is_string, c_type, _, _) in fields
    )


def c_name_to_java(name: str) -> str:
    """将 C/Hungarian 风格字段名转为 Java camelCase，并去掉类型前缀。保留尾部数字（如 iOldCode1->oldCode1）。"""
    if not name:
        return name
    # 先保留尾部数字，后续再拼回去
    trailing_digits = ""
    m = re.search(r"\d+$", name)
    if m:
        trailing_digits = m.group(0)
        name = name[: m.start()]
    if not name:
        return name + trailing_digits
    # 去掉类型前缀：ia/ba/dwa/sza 等数组前缀仅当后跟大写时 strip（如 iaClanID、dwaTempData、szaMonsterName），
    # 单字母前缀(i,s,b,c 等) 也仅在后跟大写时剥掉，避免 config 之类普通单词被误处理。
    for prefix in ("ia", "ba", "wa", "sa", "dwa", "sza", "dw", "i", "sz", "u", "w", "b", "s", "e", "c"):
        if name.lower().startswith(prefix) and len(name) > len(prefix):
            rest = name[len(prefix) :]
            if not rest:
                continue
            # 数组前缀(ia,ba,wa,sa,dwa)仅在后跟大写时剥掉；单字母前缀(s,e 等)也仅在后跟大写时剥，避免 ServerInfo->erverInfo
            if prefix in ("ia", "ba", "wa", "sa", "dwa") and not rest[0].isupper():
                continue
            if len(prefix) == 1 and not rest[0].isupper():
                continue
            if rest[0].isupper() or len(rest) > 1:
                name = rest
                break
    if not name:
        return name + trailing_digits
    # 拆成单词：连续大写+后续小写为一个词；仅连续大写为一个词（如 ID）
    words = []
    i = 0
    while i < len(name):
        if name[i].isupper():
            j = i + 1
            while j < len(name) and name[j].isupper():
                j += 1
            while j < len(name) and name[j].islower():
                j += 1
            words.append(name[i:j])
            i = j
        elif name[i].islower():
            j = i
            while j < len(name) and name[j].islower():
                j += 1
            words.append(name[i:j])
            i = j
        else:
            i += 1
    if not words:
        return name + trailing_digits
    result = words[0].lower()
    for w in words[1:]:
        result += w.capitalize()
    return result + trailing_digits


def resolve_size(s: str) -> int:
    s = s.strip()
    for k, v in MACROS.items():
        s = s.replace(k, v)
    s = s.replace("0x", "").replace("0X", "")
    try:
        return int(s, 16) if ("x" in s.lower() or s.startswith("0")) else int(s)
    except ValueError:
        return 0


def find_struct_bodies(content: str):
    pattern = re.compile(
        r"struct\s+(Packet[A-Za-z0-9_]+)\s*:\s*(Packet[A-Za-z0-9_]*)\s*\{",
        re.MULTILINE
    )
    results = []
    for m in pattern.finditer(content):
        name = m.group(1)
        parent = (m.group(2) or "Packet").strip()
        start = m.end()
        depth = 1
        i = start
        while i < len(content) and depth > 0:
            if content[i] == "{":
                depth += 1
            elif content[i] == "}":
                depth -= 1
                if depth == 0:
                    body = content[start:i].strip()
                    results.append((name, parent, body))
                    break
            i += 1
    return results


def strip_comments(line: str) -> str:
    # 去掉 // 注释
    idx = line.find("//")
    if idx >= 0:
        line = line[:idx]
    return line.strip()


def extract_union_first_struct_body(body: str):
    """若 body 仅为 union { struct X { ... } ... }; 则提取第一个 struct 的 { ... } 内容，供 parse_fields 解析。"""
    body_stripped = body.strip()
    if not body_stripped.lower().startswith("union"):
        return None
    # 找到第一个 struct XXX { 的位置
    m = re.search(r"struct\s+[A-Za-z0-9_]+\s*\{", body, re.IGNORECASE)
    if not m:
        return None
    start = m.end()  # 第一个 struct 的 { 之后
    depth = 1
    i = start
    while i < len(body) and depth > 0:
        if body[i] == "{":
            depth += 1
        elif body[i] == "}":
            depth -= 1
            if depth == 0:
                return body[start:i].strip()
        i += 1
    return None


def parse_fields(body: str):
    """解析 struct body，得到 (java_type, java_name, is_string, array_dims, c_type)."""
    fields = []
    # 先去掉 /* */ 块
    body = re.sub(r"/\*.*?\*/", " ", body, flags=re.DOTALL)
    lines = body.split("\n")
    depth = 0  # 大括号深度，0 表示顶层，只解析顶层字段
    for raw in lines:
        line = strip_comments(raw)
        depth += line.count("{") - line.count("}")
        if depth != 0 or not line or line.startswith("#") or line == "}" or line == "{":
            continue
        # 跳过 union、内部 struct 定义、enum
        if re.match(r"^\s*(union|struct|enum)\s", line):
            continue
        if "union" in line and "{" in line:
            continue
        # 匹配: TYPE name [optional array]; 或 TYPE name = value;
        # 支持 type name[N], type name[M][N]
        m = re.match(
            r"^\s*([A-Za-z0-9_]+)\s+([A-Za-z0-9_]+)\s*"
            r"(?:\[([^\]]+)\])?\s*(?:\[([^\]]+)\])?\s*(?:;|=)",
            line
        )
        if not m:
            continue
        c_type = m.group(1)
        name = m.group(2)
        dim1 = m.group(3)
        dim2 = m.group(4)
        if dim1 and "=" in dim1:
            dim1 = dim1.split("=")[0].strip()
        array_dims = []
        if dim1:
            array_dims.append(resolve_size(dim1))
        if dim2:
            array_dims.append(resolve_size(dim2))

        # 一维 char[] 统一视为 C 字符串，映射为 String，在 readBody/writeBody 中用 readCString/writeCString
        is_string = False
        if c_type == "char" and array_dims:
            if len(array_dims) == 1:
                is_string = True
            elif len(array_dims) == 2:
                is_string = True  # char[M][N] -> String[M]

        java_name = c_name_to_java(name)
        if name in JAVA_FIELD_NAME_OVERRIDES:
            java_name = JAVA_FIELD_NAME_OVERRIDES[name]
        # Java 关键字避让：class 等不能作为标识符
        if java_name == "class":
            java_name = "clazz"
        # *Param 系列统一用「首字母小写+剩余」命名，避免 WParam -> param 而 SParam/EParam -> sParam/eParam 画风不一致
        if java_name == "param" and name.endswith("Param") and len(name) >= 2:
            java_name = name[0].lower() + name[1:]
        # 同 struct 内重名时用「首字母小写+C 名剩余」区分，如 WxParam/SxParam/ExParam -> wxParam/sxParam/exParam
        seen_java_names = {f[1] for f in fields}
        if java_name in seen_java_names and len(name) >= 1:
            java_name = name[0].lower() + (name[1:] if len(name) > 1 else "")
        jtype, read_code, write_code = map_type(c_type, java_name, array_dims, is_string)
        # 注释：原 C 类型与字段名（含数组维度）；size 在 java_class_with_fields 中按 packet_body_sizes 补全
        comment_suffix = " " + name
        if array_dims:
            comment_suffix += "[" + "][".join(str(d) for d in array_dims) + "]"
        c_comment = f"  // {c_type}{comment_suffix}"
        fields.append((jtype, java_name, read_code, write_code, array_dims, is_string, c_type, name, c_comment))
    return fields


def map_type(c_type: str, name: str, array_dims: list, is_string: bool):
    """返回 (java_type, read_fragment, write_fragment)."""
    c_type_lower = c_type.lower()
    # 字符串
    if is_string and c_type == "char" and array_dims:
        n = array_dims[0]
        if len(array_dims) == 1:
            return "String", f"{name} = readCString(in, {n});", f"writeCString(out, {name}, {n});"
        # char[M][N] -> String[] (M 个字符串，每个最多 N 字节)
        m, n = array_dims[0], array_dims[1]
        return "String[]", f"for (int i = 0; i < {m}; i++) {{ {name}[i] = readCString(in, {n}); }}", f"for (int i = 0; i < {m}; i++) {{ writeCString(out, {name}[i], {n}); }}"
    # 标量
    if not array_dims:
        # C 枚举 -> Java 枚举（org.jpstale.server.common.enums）
        if c_type in C_ENUM_TO_JAVA:
            java_enum, size_bytes = C_ENUM_TO_JAVA[c_type]
            if size_bytes == 1:
                return java_enum, f"{name} = {java_enum}.fromValue(in.get() & 0xFF);", f"out.put((byte) {name}.getValue());"
            if size_bytes == 2:
                return java_enum, f"{name} = {java_enum}.fromValue((int) in.getShort());", f"out.putShort((short) {name}.getValue());"
            return java_enum, f"{name} = {java_enum}.fromValue(in.getInt());", f"out.putInt({name}.getValue());"
        # 结构体类型必须先于 "int" in c_type_lower 判断（否则 Point3D 等会被误判为 int）
        if c_type == "Point3D" or (c_type == "Point" and name in ("3d", "3D")):
            return "Point3D", f"if ({name} == null) {name} = new Point3D(); {name}.readFrom(in);", f"if ({name} != null) {name}.writeTo(out);"
        if c_type in ("_TRANS_CHAR_INFO", "TransCharInfo"):
            return "TransCharInfo", f"if ({name} == null) {name} = new TransCharInfo(); {name}.readFrom(in);", f"if ({name} != null) {name}.writeTo(out);"
        if c_type in ("_sTRANS_SERVER_INFO", "TransServerInfo"):
            return "TransServerInfo", f"if ({name} == null) {name} = new TransServerInfo(); {name}.readFrom(in);", f"if ({name} != null) {name}.writeTo(out);"
        if c_type in ("SYSTEMTIME", "SystemTime"):
            return "SystemTime", f"if ({name} == null) {name} = new SystemTime(); {name}.readFrom(in);", f"if ({name} != null) {name}.writeTo(out);"
        if c_type in STRUCT_JAVA_CLASSES:
            return c_type, f"if ({name} == null) {name} = new {c_type}(); {name}.readFrom(in);", f"if ({name} != null) {name}.writeTo(out);"
        if c_type.startswith("Packet") and c_type != "Packet":
            # 内嵌 Packet 子类，只读 body
            return c_type, f"if ({name} == null) {name} = new {c_type}(); {name}.readBody(in);", f"if ({name} != null) {name}.writeBody(out);"
        # INT64 必须先于 "int" in c_type_lower，否则 INT64 会被误判为 int
        if c_type in ("INT64", "int64_t", "uint64_t", "long"):
            return "long", f"{name} = in.getLong();", f"out.putLong({name});"
        # 单个 char 按 1 字节处理
        if c_type == "char":
            return "byte", f"{name} = in.get();", f"out.put({name});"
        # BOOL 映射为 boolean，线上传 4 字节 int
        if c_type == "BOOL":
            return "boolean", f"{name} = in.getInt() != 0;", f"out.putInt({name} ? 1 : 0);"
        if c_type in ("DWORD", "UINT", "int", "ID", "PVOID") or "int" in c_type_lower:
            return "int", f"{name} = in.getInt();", f"out.putInt({name});"
        if c_type in ("WORD", "USHORT", "short"):
            return "short", f"{name} = in.getShort();", f"out.putShort({name});"
        if c_type in ("BYTE", "byte"):
            return "byte", f"{name} = in.get();", f"out.put({name});"
        if c_type in ("float",):
            return "float", f"{name} = in.getFloat();", f"out.putFloat({name});"
        if c_type == "bool":
            return "boolean", f"{name} = in.get() != 0;", f"out.put((byte)({name} ? 1 : 0));"
        # 未知类型用 int 占位
        return "int", f"{name} = in.getInt();", f"out.putInt({name});"

    # 数组
    if len(array_dims) == 1:
        n = array_dims[0]
        if c_type in ("DWORD", "UINT", "int", "BOOL", "ID"):
            return f"int[]", f"for (int i = 0; i < {name}.length; i++) {{ {name}[i] = in.getInt(); }}", f"for (int i = 0; i < {name}.length; i++) {{ out.putInt({name}[i]); }}"
        if c_type in ("WORD", "USHORT", "short"):
            return f"short[]", f"for (int i = 0; i < {name}.length; i++) {{ {name}[i] = in.getShort(); }}", f"for (int i = 0; i < {name}.length; i++) {{ out.putShort({name}[i]); }}"
        if c_type in ("BYTE", "byte", "char"):
            return f"byte[]", f"in.get({name});", f"out.put({name});"
        if c_type == "float":
            return f"float[]", f"for (int i = 0; i < {name}.length; i++) {{ {name}[i] = in.getFloat(); }}", f"for (int i = 0; i < {name}.length; i++) {{ out.putFloat({name}[i]); }}"
        if c_type in ("uint64_t", "INT64", "int64_t", "unsigned __int64"):
            return f"long[]", f"for (int i = 0; i < {name}.length; i++) {{ {name}[i] = in.getLong(); }}", f"for (int i = 0; i < {name}.length; i++) {{ out.putLong({name}[i]); }}"
        if c_type in C_ENUM_TO_JAVA:
            _, size_bytes = C_ENUM_TO_JAVA[c_type]
            if size_bytes == 1:
                return f"{C_ENUM_TO_JAVA[c_type][0]}[]", f"for (int i = 0; i < {name}.length; i++) {{ {name}[i] = {C_ENUM_TO_JAVA[c_type][0]}.fromValue(in.get() & 0xFF); }}", f"for (int i = 0; i < {name}.length; i++) {{ out.put((byte) {name}[i].getValue()); }}"
            if size_bytes == 2:
                return f"{C_ENUM_TO_JAVA[c_type][0]}[]", f"for (int i = 0; i < {name}.length; i++) {{ {name}[i] = {C_ENUM_TO_JAVA[c_type][0]}.fromValue((int) in.getShort()); }}", f"for (int i = 0; i < {name}.length; i++) {{ out.putShort((short) {name}[i].getValue()); }}"
            jenum = C_ENUM_TO_JAVA[c_type][0]
            return f"{jenum}[]", f"for (int i = 0; i < {name}.length; i++) {{ {name}[i] = {jenum}.fromValue(in.getInt()); }}", f"for (int i = 0; i < {name}.length; i++) {{ out.putInt({name}[i].getValue()); }}"
        if c_type in ("_TRANS_CHAR_INFO", "TransCharInfo"):
            return "TransCharInfo[]", f"for (int i = 0; i < {name}.length; i++) {{ if ({name}[i] == null) {name}[i] = new TransCharInfo(); {name}[i].readFrom(in); }}", f"for (int i = 0; i < {name}.length; i++) {{ if ({name}[i] != null) {name}[i].writeTo(out); }}"
        if c_type in ("_sTRANS_SERVER_INFO", "TransServerInfo"):
            return "TransServerInfo[]", f"for (int i = 0; i < {name}.length; i++) {{ if ({name}[i] == null) {name}[i] = new TransServerInfo(); {name}[i].readFrom(in); }}", f"for (int i = 0; i < {name}.length; i++) {{ if ({name}[i] != null) {name}[i].writeTo(out); }}"
        if c_type in STRUCT_JAVA_CLASSES:
            return f"{c_type}[]", f"for (int i = 0; i < {name}.length; i++) {{ if ({name}[i] == null) {name}[i] = new {c_type}(); {name}[i].readFrom(in); }}", f"for (int i = 0; i < {name}.length; i++) {{ if ({name}[i] != null) {name}[i].writeTo(out); }}"
        return f"int[]", f"for (int i = 0; i < {name}.length; i++) {{ {name}[i] = in.getInt(); }}", f"for (int i = 0; i < {name}.length; i++) {{ out.putInt({name}[i]); }}"

    if len(array_dims) == 2:
        n1, n2 = array_dims[0], array_dims[1]
        if c_type == "int":
            return f"int[][]", f"for (int i = 0; i < {name}.length; i++) for (int j = 0; j < {name}[i].length; j++) {{ {name}[i][j] = in.getInt(); }}", f"for (int i = 0; i < {name}.length; i++) for (int j = 0; j < {name}[i].length; j++) {{ out.putInt({name}[i][j]); }}"
        if c_type == "char":
            return f"String[][]", f"for (int i = 0; i < {name}.length; i++) for (int j = 0; j < {name}[i].length; j++) {{ {name}[i][j] = readCString(in, {n2}); }}", f"for (int i = 0; i < {name}.length; i++) for (int j = 0; j < {name}[i].length; j++) {{ writeCString(out, {name}[i][j], {n2}); }}"
        return f"byte[][]", f"for (int i = 0; i < {name}.length; i++) in.get({name}[i]);", f"for (int i = 0; i < {name}.length; i++) out.put({name}[i]);"

    return "byte[]", f"in.get({name});", f"out.put({name});"


def java_class_with_fields(name: str, parent: str, body: str, packet_body_sizes: dict = None) -> str:
    pkg = "org.jpstale.server.common.protocol.struct"
    packet_body_sizes = packet_body_sizes or {}
    fields = parse_fields(body)
    used_union_body = False
    # 若顶层无字段且 body 仅为 union，则解析 union 中第一个 struct 的字段（如 PacketBuffData）
    if not fields:
        union_body = extract_union_first_struct_body(body)
        if union_body:
            fields = parse_fields(union_body)
            used_union_body = True
    if not fields:
        return java_class_stub(name, parent)

    field_decls = []
    read_lines = []
    write_lines = []

    for jtype, jname, read_code, write_code, array_dims, is_string, c_type, c_name, c_comment in fields:
        # 字段声明：Java 命名 + 原 C 类型/字段名注释 + 字段 size
        field_sz = field_size_bytes(c_type, array_dims, is_string, packet_body_sizes)
        c_comment_with_size = c_comment + f"  size: {field_sz} bytes"
        if array_dims:
            if len(array_dims) == 1:
                n = array_dims[0]
                if jtype == "String":
                    field_decls.append(f"    private String {jname};{c_comment_with_size}")
                elif jtype == "String[]":
                    field_decls.append(f"    private String[] {jname} = new String[{n}];{c_comment_with_size}")
                elif jtype == "byte[]":
                    field_decls.append(f"    private final byte[] {jname} = new byte[{n}];{c_comment_with_size}")
                elif jtype.endswith("[]"):
                    elem = jtype[:-2]
                    field_decls.append(f"    private {jtype} {jname} = new {elem}[{n}];{c_comment_with_size}")
                else:
                    field_decls.append(f"    private {jtype} {jname} = new {jtype}[{n}];{c_comment_with_size}")
            elif len(array_dims) == 2:
                n1, n2 = array_dims[0], array_dims[1]
                if jtype == "String[]":
                    field_decls.append(f"    private String[] {jname} = new String[{n1}];{c_comment_with_size}")
                elif jtype == "String[][]":
                    field_decls.append(f"    private String[][] {jname} = new String[{n1}][{n2}];{c_comment_with_size}")
                elif jtype.endswith("[][]"):
                    elem = jtype[:-4]
                    field_decls.append(f"    private {jtype} {jname} = new {elem}[{n1}][{n2}];{c_comment_with_size}")
                else:
                    field_decls.append(f"    private {jtype} {jname} = new {jtype}[{n1}][{n2}];{c_comment_with_size}")
            else:
                field_decls.append(f"    private byte[] {jname};{c_comment_with_size}")
        else:
            if jtype in STRUCT_JAVA_CLASSES:
                field_decls.append(f"    private {jtype} {jname};{c_comment_with_size}")
            elif jtype.startswith("Packet") and jtype != "Packet":
                field_decls.append(f"    private {jtype} {jname};{c_comment_with_size}")
            else:
                field_decls.append(f"    private {jtype} {jname};{c_comment_with_size}")
        read_lines.append("        " + read_code)
        write_lines.append("        " + write_code)

    size_of_body = compute_body_size(fields, packet_body_sizes)
    field_block = "\n".join(field_decls)
    # 子类需先调用父类 readBody/writeBody
    enum_class_names = {v[0] for v in C_ENUM_TO_JAVA.values()}
    used_enum_set = set()
    for jtype, *_ in fields:
        base = jtype[:-2] if jtype.endswith("[]") else jtype
        if base in enum_class_names:
            used_enum_set.add(base)
    used_enums = sorted(used_enum_set)
    import_enums = "\n".join(f"import org.jpstale.server.common.enums.{e};" for e in used_enums)
    super_read = "        super.readBody(in);\n" if parent != "Packet" else ""
    super_write = "        super.writeBody(out);\n" if parent != "Packet" else ""
    read_block = super_read + "\n".join(read_lines)
    write_block = super_write + "\n".join(write_lines)

    imports_extra = f"\n{import_enums}\n" if import_enums else ""
    # 若字段来自 union 的第一个 struct，补充说明：由 iHeader 区分变体，当前只生成该布局
    class_doc = f"""/**
 * 对应 packets.h 中 struct {name} : {parent}。
 */
"""
    if used_union_body:
        link_ref = "{@link Packet#getPktHeader() iHeader}"
        class_doc = f"""/**
 * 对应 packets.h 中 struct {name} : {parent}。
 * <p>
 * C 端包体为 union：同一段内存可为多种 struct 变体，由包头 {link_ref} 区分
 * （例如 PTKHDR_Effect_Debuff 表示按 Debuff 解释）。当前仅生成 union 中第一个 struct 的字段布局；
 * 若协议中仅使用该变体，则语义一致。
 */
"""
    return f"""package {pkg};

import lombok.Data;

import java.nio.ByteBuffer;{imports_extra}

{class_doc}
@Data
public class {name} extends {parent} {{

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = {size_of_body};

{field_block}

    @Override
    public int sizeOf() {{
        return super.sizeOf() + SIZE_OF;
    }}

    @Override
    protected void readBody(ByteBuffer in) {{
{read_block}
    }}

    @Override
    protected void writeBody(ByteBuffer out) {{
{write_block}
    }}
}}
"""


def java_class_stub(name: str, parent: str) -> str:
    """无包体成员的 Packet（C 端 struct 无成员或仅 union）：readBody/writeBody 仅注释说明，不抛异常。"""
    pkg = "org.jpstale.server.common.protocol.struct"
    super_read = "        super.readBody(in);\n        " if parent != "Packet" else ""
    super_write = "        super.writeBody(out);\n        " if parent != "Packet" else ""
    return f"""package {pkg};

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct {name} : {parent}。
 * C 端无包体成员，仅包头；readBody/writeBody 无需读写。
 */
@Data
public class {name} extends {parent} {{

    /** 本包体字节数（无包体）. */
    public static final int SIZE_OF = 0;

    @Override
    public int sizeOf() {{
        return super.sizeOf() + SIZE_OF;
    }}

    @Override
    protected void readBody(ByteBuffer in) {{
        {super_read}// C 端无包体成员，仅包头
    }}

    @Override
    protected void writeBody(ByteBuffer out) {{
        {super_write}// C 端无包体成员，仅包头
    }}
}}
"""


def load_all_headers(path_packets_h: str) -> str:
    """加载 packets.h 及 ADDITIONAL_HEADERS 中列出的头文件，合并为一份内容供解析。"""
    shared_dir = os.path.dirname(os.path.abspath(path_packets_h))
    parts = []
    with open(path_packets_h, "r", encoding="utf-8", errors="replace") as f:
        parts.append(f.read())
    for rel in ADDITIONAL_HEADERS:
        path = os.path.join(shared_dir, rel)
        if os.path.isfile(path):
            with open(path, "r", encoding="utf-8", errors="replace") as f:
                parts.append("\n")
                parts.append(f.read())
        else:
            print(f"  Warning: optional header not found: {path}", file=sys.stderr)
    return "".join(parts)


def main():
    path_h = sys.argv[1] if len(sys.argv) > 1 else DEFAULT_H
    path_out = sys.argv[2] if len(sys.argv) > 2 else DEFAULT_OUT

    if not os.path.isfile(path_h):
        print(f"Error: packets.h not found: {path_h}", file=sys.stderr)
        sys.exit(1)
    os.makedirs(path_out, exist_ok=True)

    content = load_all_headers(path_h)
    raw_structs = find_struct_bodies(content)
    # 同名只保留第一次出现（packets.h 优先）
    seen = set()
    structs = []
    for name, parent, body in raw_structs:
        if name not in seen:
            seen.add(name)
            structs.append((name, parent, body))
    print(f"Found {len(structs)} struct Packet* definitions (from packets.h + {len(ADDITIONAL_HEADERS)} extra headers).")

    # 预计算各 Packet 子类的包体大小（含嵌套 Packet 时需多轮直到稳定）
    packet_body_sizes = {}
    for _ in range(15):
        changed = False
        for name, parent, body in structs:
            if name in SKIP_ALREADY:
                continue
            fields = parse_fields(body)
            if not fields:
                union_body = extract_union_first_struct_body(body)
                if union_body:
                    fields = parse_fields(union_body)
            sz = compute_body_size(fields, packet_body_sizes) if fields else 0
            if packet_body_sizes.get(name) != sz:
                changed = True
                packet_body_sizes[name] = sz
        if not changed:
            break

    written = 0
    for idx, (name, parent, body) in enumerate(structs, 1):
        if name in SKIP_ALREADY:
            print(f"  Skip: {name}")
            continue
        java = java_class_with_fields(name, parent, body, packet_body_sizes)
        out_file = os.path.join(path_out, f"{name}.java")
        with open(out_file, "w", encoding="utf-8") as f:
            f.write(java)
        written += 1
        if written % 20 == 0:
            print(f"  Written {written}...")
    print(f"Written {written} Java files.")
    return 0


if __name__ == "__main__":
    sys.exit(main())
