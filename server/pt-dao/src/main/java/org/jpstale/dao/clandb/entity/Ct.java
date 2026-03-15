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
@TableName(schema = "clandb", value = "ct")
public class Ct {

    @TableField("s_no")
    private Integer sNo;
    @TableField("server_name")
    private String serverName;
    @TableField("midx")
    private Integer midx;
    @TableField("clan_name")
    private String clanName;
    @TableField("clan_jang")
    private Integer clanJang;
    @TableField("clan_image")
    private String clanImage;
    @TableField("user_id")
    private String userId;
    @TableField("ch_name")
    private String chName;
    @TableField("gp_code")
    private String gpCode;
    @TableField("logon_time")
    private LocalDateTime logonTime;
    @TableField("ip")
    private String ip;
    @TableField("r_no")
    private Integer rNo;
    @TableField("flag")
    private Integer flag;
}
