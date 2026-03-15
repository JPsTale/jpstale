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
@TableName(schema = "gamedb", value = "character_class")
public class CharacterClass {

    @TableField("id")
    private Integer id;
    @TableField("id2")
    private Integer id2;
    @TableField("name")
    private String name;
    @TableField("short_name")
    private String shortName;
}
