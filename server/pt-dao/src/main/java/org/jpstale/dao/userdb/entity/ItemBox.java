package org.jpstale.dao.userdb.entity;

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
@TableName(schema = "userdb", value = "item_box")
public class ItemBox {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("account_name")
    private String accountName;
    @TableField("item_code")
    private String itemCode;
    @TableField("item")
    private String item;
    @TableField("item_spec")
    private Integer itemSpec;
    @TableField("coin_shop")
    private Integer coinShop;
    @TableField("has_item")
    private Integer hasItem;
    @TableField("date_received")
    private LocalDateTime dateReceived;
}
