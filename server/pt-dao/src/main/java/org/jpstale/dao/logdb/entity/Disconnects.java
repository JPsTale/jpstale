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
@TableName(schema = "logdb", value = "disconnects")
public class Disconnects {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("ip")
    private String ip;
    @TableField("account_name")
    private String accountName;
    @TableField("net_server")
    private Integer netServer;
    @TableField("keep_alive")
    private Integer keepAlive;
    @TableField("server_type")
    private String serverType;
    @TableField("location")
    private String location;
    @TableField("return_address")
    private String returnAddress;
    @TableField("return_address_call")
    private String returnAddressCall;
    @TableField("date")
    private LocalDateTime date;
}
