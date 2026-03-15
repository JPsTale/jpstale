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
@TableName(schema = "logdb", value = "post_box_log")
public class PostBoxLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("ip")
    private String ip;
    @TableField("account_name")
    private String accountName;
    @TableField("log_id")
    private Integer logId;
    @TableField("description")
    private String description;
    @TableField("date")
    private LocalDateTime date;
    @TableField("server_id")
    private Integer serverId;
}
