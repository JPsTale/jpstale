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
@TableName(schema = "logdb", value = "event_log")
public class EventLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("character_id")
    private Integer characterId;
    @TableField("character_name")
    private String characterName;
    @TableField("event_type")
    private Integer eventType;
    @TableField("value1")
    private Integer value1;
    @TableField("value2")
    private Integer value2;
    @TableField("value3")
    private Integer value3;
    @TableField("value4")
    private Integer value4;
    @TableField("date")
    private LocalDateTime date;
}
