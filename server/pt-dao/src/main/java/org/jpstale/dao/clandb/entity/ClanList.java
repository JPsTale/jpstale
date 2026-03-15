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
@TableName(schema = "clandb", value = "clan_list")
public class ClanList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("clan_name")
    private String clanName;
    @TableField("clan_leader")
    private String clanLeader;
    @TableField("note")
    private String note;
    @TableField("account_name")
    private String accountName;
    @TableField("members_count")
    private Integer membersCount;
    @TableField("icon_id")
    private Integer iconId;
    @TableField("regis_date")
    private Integer regisDate;
    @TableField("limit_date")
    private Integer limitDate;
    @TableField("delete_active")
    private Integer deleteActive;
    @TableField("flag")
    private Integer flag;
    @TableField("siege_war_points")
    private Integer siegeWarPoints;
    @TableField("bellatra_points")
    private Integer bellatraPoints;
    @TableField("siege_war_gold")
    private Integer siegeWarGold;
    @TableField("bellatra_gold")
    private Integer bellatraGold;
    @TableField("bellatra_date")
    private Long bellatraDate;
    @TableField("login_message")
    private String loginMessage;
}
