package org.jpstale.dao.skilldb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 *
 * @author pt-dao
 * @since 2026-03-15
 */
@Data
@TableName(schema = "skilldb", value = "grand_cross")
public class GrandCross {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("skill_level")
    private Integer skillLevel;
    @TableField("added_attack_rating")
    private Integer addedAttackRating;
    @TableField("damage_boost")
    private Integer damageBoost;
    @TableField("damage_boostvs_undead")
    private Integer damageBoostvsUndead;
    @TableField("mpusage")
    private Integer mpusage;
    @TableField("stmusage")
    private Integer stmusage;
    @TableField("create_time")
    private LocalDateTime createTime;
}
