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
@TableName(schema = "logdb", value = "item_create_log")
public class ItemCreateLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("item_id")
    private Integer itemId;
    @TableField("code1")
    private Integer code1;
    @TableField("code2")
    private Integer code2;
    @TableField("item")
    private byte[] item;
    @TableField("date")
    private LocalDateTime date;
}
