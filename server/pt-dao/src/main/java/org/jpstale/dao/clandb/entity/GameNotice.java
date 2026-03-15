package org.jpstale.dao.clandb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 *
 * @author pt-dao
 * @since 2026-03-15
 */
@Data
@TableName(schema = "clandb", value = "game_notice")
public class GameNotice {

    @TableField("user_id")
    private String userId;
    @TableField("ch_name")
    private String chName;
    @TableField("server")
    private Integer server;
    @TableField("p_flag")
    private Integer pFlag;
    @TableField("txt")
    private String txt;
    @TableField("flag")
    private Integer flag;
}
