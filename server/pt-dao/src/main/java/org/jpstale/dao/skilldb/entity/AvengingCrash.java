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
@TableName(schema = "skilldb", value = "avenging_crash")
public class AvengingCrash {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("skill_level")
    private Integer skillLevel;
    @TableField("atk_rtg_boost")
    private Integer atkRtgBoost;
    @TableField("damage_boost")
    private Integer damageBoost;
    @TableField("mp_usage")
    private Integer mpUsage;
    @TableField("stm_usage")
    private Integer stmUsage;
    @TableField("create_time")
    private LocalDateTime createTime;
}
