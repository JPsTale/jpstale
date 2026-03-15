package org.jpstale.dao.serverdb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName(schema = "serverdb", value = "users_online")
public class UsersOnline {

    @TableField("id")
    private Integer id;
    @TableField("account_name")
    private String accountName;
    @TableField("character_name")
    private String characterName;
    @TableField("ip")
    private String ip;
    @TableField("character_class")
    private Integer characterClass;
    @TableField("character_level")
    private Integer characterLevel;
    @TableField("ticket")
    private Integer ticket;
    @TableField("login_time")
    private LocalDateTime loginTime;
}
