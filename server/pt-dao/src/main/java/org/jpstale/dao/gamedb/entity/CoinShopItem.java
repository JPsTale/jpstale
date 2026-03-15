package org.jpstale.dao.gamedb.entity;

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
@TableName(schema = "gamedb", value = "coin_shop_item")
public class CoinShopItem {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("tab_id")
    private Integer tabId;
    @TableField("name")
    private String name;
    @TableField("description")
    private String description;
    @TableField("code")
    private String code;
    @TableField("image")
    private String image;
    @TableField("value")
    private Integer value;
    @TableField("discount")
    private Integer discount;
    @TableField("bulk")
    private Integer bulk;
    @TableField("max_bulk")
    private Integer maxBulk;
    @TableField("is_spec")
    private Integer isSpec;
    @TableField("is_quantity")
    private Integer isQuantity;
    @TableField("disabled")
    private Integer disabled;
    @TableField("list_order")
    private Integer listOrder;
}
