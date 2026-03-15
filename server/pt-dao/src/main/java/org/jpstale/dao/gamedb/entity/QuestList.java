package org.jpstale.dao.gamedb.entity;

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
@TableName(schema = "gamedb", value = "quest_list")
public class QuestList {

    @TableId("id")
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("short_description")
    private String shortDescription;
    @TableField("description")
    private String description;
    @TableField("progress_text")
    private String progressText;
    @TableField("conclusion_text")
    private String conclusionText;
    @TableField("party")
    private Integer party;
    @TableField("multiple")
    private Integer multiple;
    @TableField("pvp")
    private Integer pvp;
    @TableField("min_level")
    private Integer minLevel;
    @TableField("max_level")
    private Integer maxLevel;
    @TableField("max_duration")
    private Integer maxDuration;
    @TableField("duration_type")
    private Integer durationType;
    @TableField("wait_time")
    private Integer waitTime;
    @TableField("map_id")
    private String mapId;
    @TableField("monster_id")
    private String monsterId;
    @TableField("required_items")
    private String requiredItems;
    @TableField("quest_type")
    private Integer questType;
    @TableField("required_quest_ids")
    private String requiredQuestIds;
    @TableField("inclusion_quest_ids")
    private String inclusionQuestIds;
    @TableField("npc_id")
    private Integer npcId;
    @TableField("progress_npc_id")
    private Integer progressNpcId;
    @TableField("conclusion_npc_id")
    private Integer conclusionNpcId;
    @TableField("auto_start_quest_id")
    private Integer autoStartQuestId;
    @TableField("class_restriction")
    private String classRestriction;
    @TableField("area_type")
    private Integer areaType;
    @TableField("min_x")
    private Integer minX;
    @TableField("max_x")
    private Integer maxX;
    @TableField("min_z")
    private Integer minZ;
    @TableField("max_z")
    private Integer maxZ;
    @TableField("radius")
    private Integer radius;
}
