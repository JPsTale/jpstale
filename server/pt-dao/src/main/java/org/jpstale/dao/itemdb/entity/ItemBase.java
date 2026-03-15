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
@TableName(schema = "itemdb", value = "item_base")
public class ItemBase {

    @TableId("item_base_id")
    private Integer itemBaseId;
    @TableField("item_base_name")
    private String itemBaseName;
    @TableField("item_base_hex")
    private byte[] itemBaseHex;
    @TableField("item_base_abbrv")
    private String itemBaseAbbrv;
}
