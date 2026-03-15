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
@TableName(schema = "clandb", value = "game_notice_group")
public class GameNoticeGroup {

    @TableField("idx")
    private Integer idx;
    @TableField("group_cd")
    private Integer groupCd;
    @TableField("main_cd")
    private Integer mainCd;
    @TableField("detail_cd")
    private Integer detailCd;
    @TableField("title")
    private String title;
    @TableField("content")
    private String content;
    @TableField("from_day")
    private LocalDateTime fromDay;
    @TableField("to_day")
    private LocalDateTime toDay;
    @TableField("regist_day")
    private LocalDateTime registDay;
    @TableField("del_active")
    private Integer delActive;
    @TableField("hit")
    private Integer hit;
    @TableField("flag")
    private Integer flag;
}
