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
@TableName(schema = "clandb", value = "siege_clan_list")
public class SiegeClanList {

    @TableField("idx")
    private Integer idx;
    @TableField("user_id")
    private String userId;
    @TableField("char_name")
    private String charName;
    @TableField("clan_name")
    private String clanName;
    @TableField("tax_rate")
    private Integer taxRate;
    @TableField("server_name")
    private String serverName;
    @TableField("server")
    private Integer server;
    @TableField("oper_from")
    private LocalDateTime operFrom;
    @TableField("oper_to")
    private LocalDateTime operTo;
    @TableField("regist_day")
    private LocalDateTime registDay;
}
