package org.jpstale.dao.gamedb.entity;

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
@TableName(schema = "gamedb", value = "map_spawn_point")
public class MapSpawnPoint {

    @TableId("id")
    private Integer id;
    @TableField("stage")
    private Integer stage;
    @TableField("x")
    private Integer x;
    @TableField("z")
    private Integer z;
    @TableField("description")
    private String description;
}
