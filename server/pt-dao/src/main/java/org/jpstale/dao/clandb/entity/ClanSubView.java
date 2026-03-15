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
@TableName(schema = "clandb", value = "clan_sub_view")
public class ClanSubView {

    @TableField("idx")
    private Integer idx;
    @TableField("midx")
    private Integer midx;
    @TableField("user_id")
    private String userId;
    @TableField("ch_name")
    private String chName;
    @TableField("ch_type")
    private Integer chType;
    @TableField("ch_lv")
    private Integer chLv;
    @TableField("clan_name")
    private String clanName;
    @TableField("permi")
    private String permi;
    @TableField("join_date")
    private LocalDateTime joinDate;
    @TableField("del_active")
    private String delActive;
    @TableField("p_flag")
    private Integer pFlag;
    @TableField("k_flag")
    private Integer kFlag;
    @TableField("server")
    private String server;
}
