package org.jpstale.dao.gamedb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName(schema = "gamedb", value = "item_value")
public class ItemValue {

    @TableField("item_list_id")
    private Integer itemListId;
    @TableField("attribute_id")
    private Integer attributeId;
    @TableField("min_value")
    private Double minValue;
    @TableField("max_value")
    private Double maxValue;
    @TableField("spec")
    private Integer spec;
}
