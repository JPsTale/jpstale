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
@TableName(schema = "clandb", value = "siege_money_log")
public class SiegeMoneyLog {

    @TableField("idx")
    private Integer idx;
    @TableField("cidx")
    private Integer cidx;
    @TableField("user_id")
    private String userId;
    @TableField("ch_name")
    private String chName;
    @TableField("server_name")
    private String serverName;
    @TableField("operator")
    private String operator;
    @TableField("oper_code")
    private String operCode;
    @TableField("siege_money")
    private Long siegeMoney;
    @TableField("regist_day")
    private LocalDateTime registDay;
}
