package org.jpstale.dao.itemdb.entity;

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
@TableName(schema = "itemdb", value = "gold_dump")
public class GoldDump {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("account_name")
    private String accountName;
    @TableField("char_name")
    private String charName;
    @TableField("warehouse_gold")
    private Integer warehouseGold;
    @TableField("character_gold")
    private Integer characterGold;
    @TableField("date_time")
    private LocalDateTime dateTime;
}
