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
@TableName(schema = "clandb", value = "bbs_sub")
public class BbsSub {

    @TableField("sidx")
    private Integer sidx;
    @TableField("mindex")
    private Integer mindex;
    @TableField("user_id")
    private String userId;
    @TableField("write_name")
    private String writeName;
    @TableField("content")
    private String content;
    @TableField("regi_date")
    private LocalDateTime regiDate;
    @TableField("regi_ip")
    private String regiIp;
    @TableField("nick_name")
    private String nickName;
}
