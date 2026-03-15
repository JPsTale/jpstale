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
@TableName(schema = "skilldb", value = "recall_hestian")
public class RecallHestian {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("skill_level")
    private Integer skillLevel;
    @TableField("attack_power")
    private Integer attackPower;
    @TableField("attack_rating")
    private Integer attackRating;
    @TableField("defense")
    private Integer defense;
    @TableField("hp")
    private Integer hp;
    @TableField("mpusage")
    private Integer mpusage;
    @TableField("stmusage")
    private Integer stmusage;
    @TableField("name")
    private String name;
    @TableField("duration")
    private Integer duration;
    @TableField("create_time")
    private LocalDateTime createTime;
}
