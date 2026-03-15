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
@TableName(schema = "clandb", value = "clan_money_log")
public class ClanMoneyLog {

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
    @TableField("clan_money")
    private Long clanMoney;
    @TableField("regist_day")
    private LocalDateTime registDay;
    @TableField("note")
    private String note;
}
