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
@TableName(schema = "clandb", value = "cl")
public class Cl {

    @TableField("id")
    private Integer id;
    @TableField("clan_name")
    private String clanName;
    @TableField("note")
    private String note;
    @TableField("note_cnt")
    private Integer noteCnt;
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
    @TableField("sod_date")
    private LocalDateTime sodDate;
    @TableField("del_active")
    private String delActive;
    @TableField("p_flag")
    private Integer pFlag;
    @TableField("k_flag")
    private Integer kFlag;
    @TableField("c_point")
    private Integer cPoint;
    @TableField("c_win")
    private Integer cWin;
    @TableField("c_fail")
    private Integer cFail;
    @TableField("clan_money")
    private Long clanMoney;
    @TableField("cn_flag")
    private Integer cnFlag;
    @TableField("siege_money")
    private Long siegeMoney;
}
