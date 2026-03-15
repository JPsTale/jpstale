package org.jpstale.dao.logdb.entity;

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
@TableName(schema = "logdb", value = "mute_player_log")
public class MutePlayerLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("account_name")
    private String accountName;
    @TableField("character_name")
    private String characterName;
    @TableField("unix_mute_start")
    private Integer unixMuteStart;
    @TableField("unix_mute_end")
    private Integer unixMuteEnd;
    @TableField("mute_count")
    private Integer muteCount;
    @TableField("mute_reason")
    private String muteReason;
    @TableField("muted_by")
    private String mutedBy;
}
