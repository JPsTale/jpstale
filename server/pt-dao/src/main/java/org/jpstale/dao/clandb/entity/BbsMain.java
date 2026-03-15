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
@TableName(schema = "clandb", value = "bbs_main")
public class BbsMain {

    @TableField("idx")
    private Integer idx;
    @TableField("midx")
    private Integer midx;
    @TableField("user_id")
    private String userId;
    @TableField("write_name")
    private String writeName;
    @TableField("title")
    private String title;
    @TableField("content")
    private String content;
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
    @TableField("nick_name")
    private String nickName;
}
