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
@TableName(schema = "clandb", value = "bellatra_team_score")
public class BellatraTeamScore {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("account_name")
    private String accountName;
    @TableField("character_name")
    private String characterName;
    @TableField("job_code")
    private Integer jobCode;
    @TableField("level")
    private Integer level;
    @TableField("clan_code")
    private Integer clanCode;
    @TableField("score")
    private Integer score;
    @TableField("kills")
    private Integer kills;
    @TableField("total_point")
    private Integer totalPoint;
    @TableField("total_user")
    private Integer totalUser;
    @TableField("success_user")
    private Integer successUser;
    @TableField("code")
    private Integer code;
    @TableField("quake")
    private Integer quake;
    @TableField("stun_seal")
    private Integer stunSeal;
    @TableField("freeze_seal")
    private Integer freezeSeal;
    @TableField("rabie_seal")
    private Integer rabieSeal;
    @TableField("stygian_seal")
    private Integer stygianSeal;
    @TableField("guardian_saint_seal")
    private Integer guardianSaintSeal;
    @TableField("point_bag")
    private Integer pointBag;
    @TableField("date")
    private String date;
}
