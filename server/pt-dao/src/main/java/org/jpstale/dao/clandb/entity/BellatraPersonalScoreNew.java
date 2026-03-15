package org.jpstale.dao.clandb.entity;

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
@TableName(schema = "clandb", value = "bellatra_personal_score_new")
public class BellatraPersonalScoreNew {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("character_id")
    private Integer characterId;
    @TableField("character_name")
    private String characterName;
    @TableField("character_class")
    private Integer characterClass;
    @TableField("character_level")
    private Integer characterLevel;
    @TableField("kills")
    private Integer kills;
    @TableField("score")
    private Integer score;
    @TableField("unix_time")
    private Integer unixTime;
    @TableField("date")
    private LocalDateTime date;
}
