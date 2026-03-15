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
@TableName(schema = "itemdb", value = "item_craft_type")
public class ItemCraftType {

    @TableId("item_craft_type_id")
    private Short itemCraftTypeId;
    @TableField("item_craft_type_name")
    private String itemCraftTypeName;
}
