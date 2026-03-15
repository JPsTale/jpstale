package org.jpstale.dao.logdb.entity;

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
@TableName(schema = "logdb", value = "users_online_record")
public class UsersOnlineRecord {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("users_online_sub_server1")
    private Integer usersOnlineSubServer1;
    @TableField("users_online_sub_server2")
    private Integer usersOnlineSubServer2;
    @TableField("users_online_sub_server3")
    private Integer usersOnlineSubServer3;
    @TableField("total_users_online")
    private Integer totalUsersOnline;
    @TableField("date")
    private LocalDateTime date;
}
