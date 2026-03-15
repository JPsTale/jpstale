package org.jpstale.dao.itemdb.entity;

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
@TableName(schema = "itemdb", value = "item")
public class Item {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("character_id")
    private Integer characterId;
    @TableField("location")
    private Integer location;
    @TableField("data")
    private byte[] data;
    @TableField("header")
    private Integer header;
    @TableField("timestamp")
    private Integer timestamp;
    @TableField("checksum")
    private Integer checksum;
    @TableField("backup_header")
    private Integer backupHeader;
    @TableField("backup_checksum")
    private Integer backupChecksum;
    @TableField("flags")
    private Integer flags;
    @TableField("create_time")
    private LocalDateTime createTime;
    @TableField("delete_time")
    private LocalDateTime deleteTime;
}
