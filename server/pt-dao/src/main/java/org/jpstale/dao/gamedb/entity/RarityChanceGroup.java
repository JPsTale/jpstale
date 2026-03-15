package org.jpstale.dao.gamedb.entity;

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
@TableName(schema = "gamedb", value = "rarity_chance_group")
public class RarityChanceGroup {

    @TableId("id")
    private Integer id;
    @TableField("min_level")
    private Integer minLevel;
    @TableField("max_level")
    private Integer maxLevel;
}
