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
@TableName(schema = "gamedb", value = "drop_item")
public class DropItem {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("drop_id")
    private Integer dropId;
    @TableField("items")
    private String items;
    @TableField("chance")
    private Integer chance;
    @TableField("gold_min")
    private Integer goldMin;
    @TableField("gold_max")
    private Integer goldMax;
}
