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
@TableName(schema = "clandb", value = "clan_home")
public class ClanHome {

    @TableField("idx")
    private Integer idx;
    @TableField("midx")
    private Integer midx;
    @TableField("sel_server")
    private Integer selServer;
    @TableField("intro")
    private String intro;
    @TableField("image")
    private String image;
    @TableField("skin")
    private Integer skin;
    @TableField("priv_home")
    private Integer privHome;
    @TableField("priv_mem")
    private Integer privMem;
    @TableField("priv_board")
    private Integer privBoard;
}
