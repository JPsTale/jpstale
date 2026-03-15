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
@TableName(schema = "logdb", value = "server_log")
public class ServerLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("type")
    private Integer type;
    @TableField("server")
    private Integer server;
    @TableField("message")
    private String message;
    @TableField("unix_time")
    private Integer unixTime;
    @TableField("date")
    private LocalDateTime date;
}
