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
@TableName(schema = "gamedb", value = "map_boss")
public class MapBoss {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("map_id")
    private Integer mapId;
    @TableField("boss_monster_id")
    private Integer bossMonsterId;
    @TableField("minion_monster_id")
    private Integer minionMonsterId;
    @TableField("minion_count")
    private Integer minionCount;
}
