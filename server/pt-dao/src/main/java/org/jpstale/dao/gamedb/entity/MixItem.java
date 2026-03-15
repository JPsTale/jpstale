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
@TableName(schema = "gamedb", value = "mix_item")
public class MixItem {

    @TableId(value = "id", type = IdType.AUTO)
    private Short id;
    @TableField("mix_id")
    private Short mixId;
    @TableField("item_sub_type_id")
    private Integer itemSubTypeId;
}
