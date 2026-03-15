package org.jpstale.dao.serverdb.entity;

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
@TableName(schema = "serverdb", value = "crash_data")
public class CrashData {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("account_name")
    private String accountName;
    @TableField("ip")
    private String ip;
    @TableField("version")
    private Integer version;
    @TableField("address")
    private Integer address;
    @TableField("flags")
    private Integer flags;
    @TableField("code")
    private Integer code;
    @TableField("eax")
    private Integer eax;
    @TableField("ecx")
    private Integer ecx;
    @TableField("edx")
    private Integer edx;
    @TableField("ebx")
    private Integer ebx;
    @TableField("esp")
    private Integer esp;
    @TableField("ebp")
    private Integer ebp;
    @TableField("esi")
    private Integer esi;
    @TableField("edi")
    private Integer edi;
    @TableField("eip")
    private Integer eip;
    @TableField("date_received")
    private LocalDateTime dateReceived;
}
