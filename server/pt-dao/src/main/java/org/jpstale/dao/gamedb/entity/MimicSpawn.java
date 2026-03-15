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
@TableName(schema = "gamedb", value = "mimic_spawn")
public class MimicSpawn {

    @TableField("map_id")
    private Integer mapId;
    @TableField("mimic_name")
    private Integer mimicName;
    @TableField("spawn_chance")
    private Integer spawnChance;
    @TableField("min_delay_between_spawn")
    private Integer minDelayBetweenSpawn;
}
