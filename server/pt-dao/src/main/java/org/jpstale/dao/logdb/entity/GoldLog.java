package org.jpstale.dao.logdb.entity;

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
@TableName(schema = "logdb", value = "gold_log")
public class GoldLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("account_name")
    private String accountName;
    @TableField("source")
    private Integer source;
    @TableField("gold")
    private Integer gold;
    @TableField("inventory_gold")
    private Integer inventoryGold;
    @TableField("str")
    private String str;
    @TableField("date")
    private LocalDateTime date;
    @TableField("is_game_server")
    private Integer isGameServer;
}
