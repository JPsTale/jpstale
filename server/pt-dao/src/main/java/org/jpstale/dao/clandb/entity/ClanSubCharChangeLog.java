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
@TableName(schema = "clandb", value = "clan_sub_char_change_log")
public class ClanSubCharChangeLog {

    @TableField("idx")
    private Integer idx;
    @TableField("user_id")
    private String userId;
    @TableField("before_char_name")
    private String beforeCharName;
    @TableField("after_char_name")
    private String afterCharName;
    @TableField("c_server")
    private Integer cServer;
    @TableField("regi_date")
    private LocalDateTime regiDate;
}
