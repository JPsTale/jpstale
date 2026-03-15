package org.jpstale.dao.gamedb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName(schema = "gamedb", value = "map_npc")
public class MapNpc {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("stage")
    private Integer stage;
    @TableField("x")
    private Integer x;
    @TableField("y")
    private Integer y;
    @TableField("z")
    private Integer z;
    @TableField("angle")
    private Integer angle;
    @TableField("id_npc")
    private Integer idNpc;
    @TableField("enabled")
    private Integer enabled;
    @TableField("only_gm")
    private Integer onlyGm;
}
