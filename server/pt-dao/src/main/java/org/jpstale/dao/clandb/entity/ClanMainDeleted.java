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
@TableName(schema = "clandb", value = "clan_main_deleted")
public class ClanMainDeleted {

    @TableField("idx")
    private Integer idx;
    @TableField("midx")
    private Integer midx;
    @TableField("clan_name")
    private String clanName;
    @TableField("user_id")
    private String userId;
    @TableField("clan_zang")
    private String clanZang;
    @TableField("flag")
    private Integer flag;
    @TableField("mem_cnt")
    private Integer memCnt;
    @TableField("m_icon_cnt")
    private Integer mIconCnt;
    @TableField("regi_date")
    private LocalDateTime regiDate;
    @TableField("limit_date")
    private LocalDateTime limitDate;
    @TableField("del_date")
    private LocalDateTime delDate;
    @TableField("del_active")
    private String delActive;
    @TableField("p_flag")
    private Integer pFlag;
    @TableField("k_flag")
    private Integer kFlag;
    @TableField("del_state")
    private String delState;
    @TableField("del_case")
    private String delCase;
    @TableField("server")
    private Integer server;
}
