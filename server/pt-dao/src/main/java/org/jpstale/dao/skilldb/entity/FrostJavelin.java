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
@TableName(schema = "skilldb", value = "frost_javelin")
public class FrostJavelin {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("skill_level")
    private Integer skillLevel;
    @TableField("damage_min")
    private Integer damageMin;
    @TableField("damage_max")
    private Integer damageMax;
    @TableField("enemy_speed_reduction")
    private Integer enemySpeedReduction;
    @TableField("freeze_time")
    private Integer freezeTime;
    @TableField("duration")
    private Integer duration;
    @TableField("mpusage")
    private Integer mpusage;
    @TableField("stmusage")
    private Integer stmusage;
    @TableField("create_time")
    private LocalDateTime createTime;
}
