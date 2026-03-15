# ClanSystem ASP SQL 迁移清单

**日期**: 2026-03-15  
**范围**: PristonTale-EU-main ClanSystem（ASP）中使用的 SQL，在 jpstale 的 clandb 与 pt-dao 中实现（PostgreSQL + Mapper XML）。

## 1. 数据库与表对应

- **ASP 连接**: ClanDB（SQL Server），settings.asp 中 `dbname = "ClanDB"`。
- **jpstale**: schema `clandb`，表名小写 + 下划线：`cl`、`ul`、`ct`、`li`、`clan_list`。
- **ASP 表 → PG 表**: CL→clandb.cl, UL→clandb.ul, CT→clandb.ct, LI→clandb.li, ClanList→clandb.clan_list。
- **说明**: ASP 中 CL 表主键列名为 IDX，在 PG 中对应 `cl.id`（IDENTITY）。

## 2. 已实现的 Mapper 方法（按 ASP 文件）

### settings.asp
- `CheckTicket`: SELECT SNo FROM CT WHERE UserID=? AND ServerName=?  
  → **CtMapper.selectSNoByUserIdAndServerName**

### InviteClan.asp
- SELECT IDX,ClanZang,MemCnt FROM CL WHERE ClanName=? → **ClMapper.selectIdClanZangMemCntByClanName**
- SELECT ChName FROM UL WHERE Permi=2 AND ClanName=? → **UlMapper.selectChNameByPermi2AndClanName**
- SELECT ClanName FROM UL WHERE ChName=? → **UlMapper.selectClanNameByChName**
- DELETE FROM UL WHERE ChName=? → **UlMapper.deleteByChName**
- UPDATE CL SET MemCnt=? WHERE ClanName=? → **ClMapper.updateMemCntByClanName**
- INSERT INTO UL (...) → **UlMapper.insertUl**

### NewClan.asp
- SELECT ClanName FROM UL WHERE ChName=? → **UlMapper.selectClanNameByChName**
- DELETE FROM UL WHERE ChName=? → **UlMapper.deleteByChName**
- SELECT ClanZang FROM CL WHERE ClanName=? → **ClMapper.selectClanZangByClanName**
- SELECT IMG FROM LI WHERE ID=1 → **LiMapper.selectImgById** (id=1)
- INSERT INTO LI / UPDATE LI SET IMG=? WHERE ID=1 → **LiMapper.insertLi** / **LiMapper.updateImgById**
- INSERT INTO CL (...) → **ClMapper.insertCl**
- SELECT IDX FROM CL WHERE ClanName=? → **ClMapper.selectIdByClanName**
- INSERT INTO UL (...) → **UlMapper.insertUl**
- INSERT INTO ClanList (...) → **ClanListMapper.insertClanList**
- SELECT ID FROM CLANLIST WHERE ClanName=? → **ClanListMapper.selectIdByClanName**
- update UserDb..CharacterInfo set ClanId=? where Name=? → **userdb.CharacterInfoMapper**（已有）

### DeleteClan.asp
- SELECT * FROM ClanList WHERE AccountName=? → **ClanListMapper.selectByAccountName**
- SELECT ClanLeader FROM ClanList WHERE ClanName=? → **ClanListMapper.selectClanLeaderByClanName**
- DELETE FROM ClanList/CL/UL WHERE ClanName=? → **ClanListMapper.deleteByClanName**, **ClMapper.deleteByClanName**, **UlMapper.deleteByClanName**
- update UserDb..CharacterInfo set ClanId=0 where ClanName=? → **userdb.CharacterInfoMapper**（需按 name 更新可补）

### LeavePlayer.asp / LeavePlayerSelf.asp
- SELECT ClanName FROM UL WHERE ChName=? → **UlMapper.selectClanNameByChName** / **UlMapper.selectClanNameAndPermiByChName**
- DELETE FROM UL WHERE ChName=? → **UlMapper.deleteByChName**
- SELECT ClanZang,MemCnt FROM CL WHERE ClanName=? → **ClMapper.selectIdClanZangMemCntByClanName**
- UPDATE CL SET MemCnt=? → **ClMapper.updateMemCntByClanName**

### ClanMember.asp
- SELECT ClanZang,MemCnt,Note,... FROM CL WHERE ClanName=? → **ClMapper.selectClanZangMemCntNoteMIconCntRegiDateLimitDatePFlagKFlagClanMoneyByClanName**
- SELECT * FROM CL ORDER BY Cpoint DESC → **ClMapper.selectByClanNameOrderByCpointDesc**
- SELECT ChName FROM UL WHERE ClanName=? AND Permi=2 → **UlMapper.selectChNameByPermi2AndClanName**
- UPDATE UL SET MIconCnt=? WHERE ChName=? → **UlMapper.updateMIconCntByChName**

### ChangeLeader.asp
- SELECT userid FROM UL WHERE ChName=? AND ClanName=? → **UlMapper.selectUserIdByChNameAndClanName**
- UPDATE CL SET ClanZang=?, UserID=? WHERE ClanName=? → **ClMapper.updateClanZangAndUserIdByClanName**

### SubLeaderRelease.asp / SubLeaderUpdate.asp
- UPDATE UL SET Permi=0 WHERE ChName=? → **UlMapper.updatePermi0ByChName**
- UPDATE UL SET Permi=2 WHERE ChName=? → **UlMapper.updatePermi2ByChName**
- UPDATE UL SET Permi=0 WHERE ClanName IN (SELECT ClanName FROM UL WHERE ChName=?) → **UlMapper.updatePermi0ByClanNameInChName**

### CheckClanLeader.asp / GetClanMembers.asp / CheckDate.asp / CheckUnknown.asp / CheckClanID.asp / CheckClanName.asp / SodScore.asp
- 上述 SELECT/UPDATE 均已对应到 **ClMapper** / **UlMapper** / **ClanListMapper** 中相应方法。

## 3. 跨库说明

- **UserDb..CharacterInfo**：ASP 中更新 CharacterInfo 的 ClanId/ClanName 在 userdb schema，由 **CharacterInfoMapper** 提供；若需按 ClanName 批量置 ClanId=0，可在 CharacterInfoMapper 中增加对应 update 方法。

## 4. 校验

- 已执行 `mvn -q clean compile` 于 `server/pt-dao`，通过。
- 表结构见 `server/postgres-init/01-create-clandb.sql`（cl、ul、ct、li、clan_list 等）。

## 5. 参考

- 源 ASP 目录: `PristonTale-EU-main/ClanSystem/Clan/*.asp`
- 设计/清单: [2026-03-15-cpp-sql-to-pt-dao-migration-checklist.md](2026-03-15-cpp-sql-to-pt-dao-migration-checklist.md)
