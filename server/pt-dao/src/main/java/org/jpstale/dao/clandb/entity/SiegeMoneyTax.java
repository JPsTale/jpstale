package org.jpstale.dao.clandb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName(schema = "clandb", value = "siege_money_tax")
public class SiegeMoneyTax {

    @TableField("d_no")
    private Integer dNo;
    @TableField("idx")
    private Integer idx;
    @TableField("mixing")
    private Long mixing;
    @TableField("aging")
    private Long aging;
    @TableField("shop")
    private Long shop;
    @TableField("poison1")
    private Long poison1;
    @TableField("poison2")
    private Long poison2;
    @TableField("poison3")
    private Long poison3;
    @TableField("force")
    private Long force;
    @TableField("warpgate")
    private Long warpgate;
    @TableField("skill")
    private Long skill;
    @TableField("total")
    private Long total;
    @TableField("tax")
    private Long tax;
    @TableField("server_name")
    private String serverName;
    @TableField("regist_day")
    private LocalDateTime registDay;
}
