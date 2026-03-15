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
@TableName(schema = "gamedb", value = "baseline_mod")
public class BaselineMod {

    @TableId("clazz")
    private Integer clazz;
    @TableField("percent_baseline_strength")
    private Integer percentBaselineStrength;
    @TableField("percent_baseline_spirit")
    private Integer percentBaselineSpirit;
    @TableField("percent_baseline_talent")
    private Integer percentBaselineTalent;
    @TableField("percent_baseline_agility")
    private Integer percentBaselineAgility;
    @TableField("percent_baseline_health")
    private Integer percentBaselineHealth;
}
