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
@TableName(schema = "gamedb", value = "mix_value")
public class MixValue {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("mix_id")
    private Short mixId;
    @TableField("effect_id")
    private Short effectId;
    @TableField("value")
    private Double value;
    @TableField("effect_type_id")
    private Integer effectTypeId;
}
