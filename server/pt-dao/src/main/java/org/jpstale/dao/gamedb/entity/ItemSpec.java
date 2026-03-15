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
@TableName(schema = "gamedb", value = "item_spec")
public class ItemSpec {

    @TableField("item_id")
    private Integer itemId;
    @TableField("character_class_id")
    private Integer characterClassId;
    @TableField("main_spec")
    private Integer mainSpec;
}
