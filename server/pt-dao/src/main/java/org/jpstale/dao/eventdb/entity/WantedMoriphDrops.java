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
@TableName(schema = "eventdb", value = "wanted_moriph_drops")
public class WantedMoriphDrops {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("char_id")
    private Integer charId;
    @TableField("map_id")
    private Integer mapId;
    @TableField("item_name")
    private String itemName;
    @TableField("unix_time")
    private Integer unixTime;
}
