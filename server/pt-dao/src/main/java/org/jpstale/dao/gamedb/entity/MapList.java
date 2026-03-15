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
@TableName(schema = "gamedb", value = "map_list")
public class MapList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("short_name")
    private String shortName;
    @TableField("type_map")
    private String typeMap;
    @TableField("level_req")
    private Integer levelReq;
    @TableField("pvp")
    private Integer pvp;
    @TableField("stage_file")
    private String stageFile;
}
