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
@TableName(schema = "logdb", value = "coin_log")
public class CoinLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("account_name")
    private String accountName;
    @TableField("description")
    private String description;
    @TableField("date")
    private LocalDateTime date;
}
