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
@TableName(schema = "logdb", value = "inventory_item_log")
public class InventoryItemLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("user_id")
    private String userId;
    @TableField("char_name")
    private String charName;
    @TableField("action")
    private Integer action;
    @TableField("item_name")
    private String itemName;
    @TableField("item_id")
    private Integer itemId;
    @TableField("code1")
    private Integer code1;
    @TableField("code2")
    private Integer code2;
    @TableField("date")
    private LocalDateTime date;
}
