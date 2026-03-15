package org.jpstale.dao.clandb.entity;

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
@TableName(schema = "clandb", value = "bellatra_personal_score")
public class BellatraPersonalScore {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("account_name")
    private String accountName;
    @TableField("character_name")
    private String characterName;
    @TableField("kills")
    private Integer kills;
    @TableField("score")
    private Integer score;
    @TableField("date")
    private String date;
}
