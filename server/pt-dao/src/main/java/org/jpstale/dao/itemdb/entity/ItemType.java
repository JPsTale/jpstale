package org.jpstale.dao.itemdb.entity;

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
@TableName(schema = "itemdb", value = "item_type")
public class ItemType {

    @TableId("item_type_id")
    private Integer itemTypeId;
    @TableField("item_type_name")
    private String itemTypeName;
    @TableField("item_type_hex")
    private byte[] itemTypeHex;
    @TableField("item_type_abbrv")
    private String itemTypeAbbrv;
}
