package org.jpstale.dao.serverdb.entity;

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
@TableName(schema = "serverdb", value = "spawn_camera")
public class SpawnCamera {

    @TableField("id")
    private Integer id;
    @TableField("map_number")
    private Integer mapNumber;
    @TableField("spawn_x")
    private Integer spawnX;
    @TableField("spawn_y")
    private Integer spawnY;
    @TableField("spawn_z")
    private Integer spawnZ;
    @TableField("cam_x_coord")
    private Integer camXCoord;
    @TableField("cam_z_coord")
    private Integer camZCoord;
    @TableField("cam_turn")
    private Integer camTurn;
    @TableField("cam_angle")
    private Integer camAngle;
    @TableField("cam_zoom")
    private Integer camZoom;
    @TableField("min_player_count")
    private Integer minPlayerCount;
    @TableField("search_radius")
    private Integer searchRadius;
    @TableField("spawn_type")
    private Integer spawnType;
}
