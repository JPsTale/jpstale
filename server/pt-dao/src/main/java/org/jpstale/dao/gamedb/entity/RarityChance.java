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
@TableName(schema = "gamedb", value = "rarity_chance")
public class RarityChance {

    @TableField("rarity_chance_group")
    private Integer rarityChanceGroup;
    @TableField("rarity")
    private Integer rarity;
    @TableField("chance")
    private Integer chance;
}
