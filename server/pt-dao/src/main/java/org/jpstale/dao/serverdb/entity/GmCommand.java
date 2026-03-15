package org.jpstale.dao.serverdb.entity;

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
@TableName(schema = "serverdb", value = "gm_command")
public class GmCommand {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("account_name")
    private String accountName;
    @TableField("command")
    private String command;
    @TableField("unix_time")
    private Integer unixTime;
    @TableField("unix_time_to_execute")
    private Integer unixTimeToExecute;
    @TableField("is_active")
    private Integer isActive;
    @TableField("result")
    private Integer result;
}
