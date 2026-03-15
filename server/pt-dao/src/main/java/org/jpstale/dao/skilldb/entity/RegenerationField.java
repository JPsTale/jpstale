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
@TableName(schema = "skilldb", value = "regeneration_field")
public class RegenerationField {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("skill_level")
    private Integer skillLevel;
    @TableField("added_hprecovery")
    private Integer addedHprecovery;
    @TableField("added_mprecovery")
    private Integer addedMprecovery;
    @TableField("duration_seconds")
    private Integer durationSeconds;
    @TableField("area")
    private Integer area;
    @TableField("mpusage")
    private Integer mpusage;
    @TableField("stmusage")
    private Integer stmusage;
    @TableField("create_time")
    private LocalDateTime createTime;
}
