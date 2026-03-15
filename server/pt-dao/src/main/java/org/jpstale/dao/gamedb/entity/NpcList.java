package org.jpstale.dao.gamedb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 *
 * @author pt-dao
 * @since 2026-03-15
 */
@Data
@TableName(schema = "gamedb", value = "npc_list")
public class NpcList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("game_file")
    private String gameFile;
    @TableField("message1")
    private String message1;
    @TableField("message2")
    private String message2;
    @TableField("message3")
    private String message3;
    @TableField("message4")
    private String message4;
    @TableField("event_type")
    private Integer eventType;
    @TableField("event_param")
    private Integer eventParam;
    @TableField("skill_quests")
    private Integer skillQuests;
    @TableField("quest_id")
    private Integer questId;
    @TableField("quest_type_id")
    private Integer questTypeId;
    @TableField("quest_type_sub_id")
    private Integer questTypeSubId;
    @TableField("teleport_id")
    private Integer teleportId;
    @TableField("weapon_shop")
    private String weaponShop;
    @TableField("defense_shop")
    private String defenseShop;
    @TableField("misc_shop")
    private String miscShop;
}
