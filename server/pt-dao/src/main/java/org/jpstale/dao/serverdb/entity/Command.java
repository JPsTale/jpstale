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
@TableName(schema = "serverdb", value = "command")
public class Command {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("command_type_id")
    private Integer commandTypeId;
    @TableField("parameter1")
    private String parameter1;
    @TableField("parameter2")
    private String parameter2;
    @TableField("parameter3")
    private String parameter3;
    @TableField("date_processed")
    private LocalDateTime dateProcessed;
}
