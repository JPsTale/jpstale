package org.jpstale.dao.userdb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.Instant;
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
@TableName(schema = "userdb", value = "user_info")
public class UserInfo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("account_name")
    private String accountName;
    @TableField("password")
    private String password;
    /** 注册时间，UTC 存库，展示时按用户时区格式化 */
    @TableField("regis_day")
    private Instant regisDay;
    @TableField("flag")
    private Integer flag;
    @TableField("active")
    private Integer active;
    @TableField("active_code")
    private String activeCode;
    @TableField("coins")
    private Integer coins;
    @TableField("email")
    private String email;
    @TableField("game_master_type")
    private Integer gameMasterType;
    @TableField("game_master_level")
    private Integer gameMasterLevel;
    @TableField("game_master_mac_address")
    private String gameMasterMacAddress;
    @TableField("coins_traded")
    private Integer coinsTraded;
    @TableField("ban_status")
    private Integer banStatus;
    @TableField("unban_date")
    private LocalDateTime unbanDate;
    @TableField("is_muted")
    private Integer isMuted;
    @TableField("mute_count")
    private Integer muteCount;
    @TableField("unmute_date")
    private LocalDateTime unmuteDate;
}
