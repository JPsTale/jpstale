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
@TableName(schema = "gamedb", value = "rarity_chance_mod")
public class RarityChanceMod {

    @TableId("type")
    private Integer type;
    @TableField("mod_common")
    private Double modCommon;
    @TableField("mod_uncommon")
    private Double modUncommon;
    @TableField("mod_rare")
    private Double modRare;
    @TableField("mod_epic")
    private Double modEpic;
    @TableField("mod_legendary")
    private Double modLegendary;
}
