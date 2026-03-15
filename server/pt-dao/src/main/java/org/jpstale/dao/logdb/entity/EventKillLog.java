package org.jpstale.dao.logdb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName(schema = "logdb", value = "event_kill_log")
public class EventKillLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("event_id")
    private Integer eventId;
    @TableField("map_id")
    private Integer mapId;
    @TableField("character_id")
    private Integer characterId;
    @TableField("monster_id")
    private Integer monsterId;
    @TableField("monster_effect_id")
    private Integer monsterEffectId;
    @TableField("date_time")
    private LocalDateTime dateTime;
}
