package org.jpstale.dao.eventdb.entity;

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
@TableName(schema = "eventdb", value = "fury_arena_reward_tracker")
public class FuryArenaRewardTracker {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("fury_event_id")
    private Integer furyEventId;
    @TableField("character_id")
    private Integer characterId;
}
