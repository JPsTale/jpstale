package org.jpstale.dao.serverdb.entity;

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
@TableName(schema = "serverdb", value = "bellatra_reward")
public class BellatraReward {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("item_code")
    private String itemCode;
    @TableField("quantity")
    private Integer quantity;
    @TableField("percent")
    private Integer percent;
}
