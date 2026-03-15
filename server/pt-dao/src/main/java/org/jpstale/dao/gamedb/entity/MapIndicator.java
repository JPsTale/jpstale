package org.jpstale.dao.gamedb.entity;

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
@TableName(schema = "gamedb", value = "map_indicator")
public class MapIndicator {

    @TableField("map_id")
    private Integer mapId;
    @TableField("type")
    private Integer type;
    @TableField("value")
    private Integer value;
    @TableField("pos_x")
    private Integer posX;
    @TableField("pos_z")
    private Integer posZ;
    @TableField("angle_y")
    private Integer angleY;
}
