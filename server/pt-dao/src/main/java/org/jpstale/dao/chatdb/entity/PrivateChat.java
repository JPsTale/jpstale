package org.jpstale.dao.chatdb.entity;

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
@TableName(schema = "chatdb", value = "private_chat")
public class PrivateChat {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("sender_name")
    private String senderName;
    @TableField("receiver_name")
    private String receiverName;
    @TableField("message")
    private String message;
    @TableField("unix_time")
    private Integer unixTime;
}
