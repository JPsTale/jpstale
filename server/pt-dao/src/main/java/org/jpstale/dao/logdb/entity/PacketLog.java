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
@TableName(schema = "logdb", value = "packet_log")
public class PacketLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("server_type")
    private Integer serverType;
    @TableField("packet_id")
    private Integer packetId;
    @TableField("total_count")
    private Integer totalCount;
    @TableField("total_duration_ms")
    private Long totalDurationMs;
    @TableField("min_duration_ms")
    private Integer minDurationMs;
    @TableField("max_duration_ms")
    private Integer maxDurationMs;
    @TableField("date_time")
    private LocalDateTime dateTime;
}
