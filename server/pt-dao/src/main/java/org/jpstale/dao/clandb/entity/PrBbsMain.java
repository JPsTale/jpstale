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
@TableName(schema = "clandb", value = "pr_bbs_main")
public class PrBbsMain {

    @TableField("idx")
    private Integer idx;
    @TableField("pm_no")
    private String pmNo;
    @TableField("user_id")
    private String userId;
    @TableField("title")
    private String title;
    @TableField("content")
    private String content;
    @TableField("user_name")
    private String userName;
    @TableField("clan_idx")
    private Integer clanIdx;
    @TableField("sel_server")
    private Integer selServer;
    @TableField("regi_date")
    private LocalDateTime regiDate;
    @TableField("regi_ip")
    private String regiIp;
    @TableField("hit")
    private Integer hit;
    @TableField("count_com")
    private Integer countCom;
}
