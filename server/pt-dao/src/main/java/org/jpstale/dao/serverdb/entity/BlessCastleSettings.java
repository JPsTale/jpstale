package org.jpstale.dao.serverdb.entity;

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
@TableName(schema = "serverdb", value = "bless_castle_settings")
public class BlessCastleSettings {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("clan_id1")
    private Integer clanId1;
    @TableField("clan_id2")
    private Integer clanId2;
    @TableField("clan_id3")
    private Integer clanId3;
    @TableField("tax")
    private Integer tax;
    @TableField("skill")
    private Integer skill;
    @TableField("tower1_type")
    private Integer tower1Type;
    @TableField("tower2_type")
    private Integer tower2Type;
    @TableField("tower3_type")
    private Integer tower3Type;
    @TableField("tower4_type")
    private Integer tower4Type;
    @TableField("tower5_type")
    private Integer tower5Type;
    @TableField("tower6_type")
    private Integer tower6Type;
    @TableField("guard1_amount")
    private Integer guard1Amount;
    @TableField("guard2_amount")
    private Integer guard2Amount;
    @TableField("guard3_amount")
    private Integer guard3Amount;
}
