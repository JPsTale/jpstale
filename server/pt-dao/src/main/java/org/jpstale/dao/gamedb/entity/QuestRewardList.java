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
@TableName(schema = "gamedb", value = "quest_reward_list")
public class QuestRewardList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("quest_id")
    private Integer questId;
    @TableField("name")
    private String name;
    @TableField("monster_quantities")
    private String monsterQuantities;
    @TableField("required_drop_quantities")
    private String requiredDropQuantities;
    @TableField("exp_reward")
    private Long expReward;
    @TableField("exp_pot_bonus")
    private Integer expPotBonus;
    @TableField("exp_level_difference")
    private Integer expLevelDifference;
    @TableField("item_reward_select")
    private Integer itemRewardSelect;
    @TableField("items_reward")
    private String itemsReward;
    @TableField("items_reward_quantities")
    private String itemsRewardQuantities;
    @TableField("extra_reward_type")
    private String extraRewardType;
    @TableField("extra_reward_values")
    private String extraRewardValues;
    @TableField("time_multiplier")
    private Integer timeMultiplier;
}
