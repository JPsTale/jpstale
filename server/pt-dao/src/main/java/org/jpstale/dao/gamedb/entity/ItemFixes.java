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
@TableName(schema = "gamedb", value = "item_fixes")
public class ItemFixes {

    @TableId("id")
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("min_level")
    private Integer minLevel;
    @TableField("max_level")
    private Integer maxLevel;
    @TableField("min_rarity")
    private Integer minRarity;
    @TableField("max_rarity")
    private Integer maxRarity;
    @TableField("is_prefix")
    private Integer isPrefix;
    @TableField("is_suffix")
    private Integer isSuffix;
    @TableField("chance")
    private Integer chance;
    @TableField("axes")
    private Integer axes;
    @TableField("bows")
    private Integer bows;
    @TableField("javelins")
    private Integer javelins;
    @TableField("daggers")
    private Integer daggers;
    @TableField("wands")
    private Integer wands;
    @TableField("scythes")
    private Integer scythes;
    @TableField("swords")
    private Integer swords;
    @TableField("claws")
    private Integer claws;
    @TableField("hammers")
    private Integer hammers;
    @TableField("phantoms")
    private Integer phantoms;
    @TableField("armors")
    private Integer armors;
    @TableField("robes")
    private Integer robes;
    @TableField("boots")
    private Integer boots;
    @TableField("gauntlets")
    private Integer gauntlets;
    @TableField("bracelets")
    private Integer bracelets;
    @TableField("amulets")
    private Integer amulets;
    @TableField("rings")
    private Integer rings;
    @TableField("shields")
    private Integer shields;
    @TableField("orbs")
    private Integer orbs;
    @TableField("organic_min")
    private Integer organicMin;
    @TableField("organic_max")
    private Integer organicMax;
    @TableField("fire_min")
    private Integer fireMin;
    @TableField("fire_max")
    private Integer fireMax;
    @TableField("frost_min")
    private Integer frostMin;
    @TableField("frost_max")
    private Integer frostMax;
    @TableField("lightning_min")
    private Integer lightningMin;
    @TableField("lightning_max")
    private Integer lightningMax;
    @TableField("poison_min")
    private Integer poisonMin;
    @TableField("poison_max")
    private Integer poisonMax;
    @TableField("atk_pow_min")
    private Integer atkPowMin;
    @TableField("atk_pow_max")
    private Integer atkPowMax;
    @TableField("range_min")
    private Integer rangeMin;
    @TableField("range_max")
    private Integer rangeMax;
    @TableField("atk_rating_min")
    private Integer atkRatingMin;
    @TableField("atk_rating_max")
    private Integer atkRatingMax;
    @TableField("critical_min")
    private Double criticalMin;
    @TableField("critical_max")
    private Double criticalMax;
    @TableField("block_min")
    private Double blockMin;
    @TableField("block_max")
    private Double blockMax;
    @TableField("absorb_min")
    private Double absorbMin;
    @TableField("absorb_max")
    private Double absorbMax;
    @TableField("defense_min")
    private Integer defenseMin;
    @TableField("defense_max")
    private Integer defenseMax;
    @TableField("regeneration_hp_min")
    private Double regenerationHpMin;
    @TableField("regeneration_hp_max")
    private Double regenerationHpMax;
    @TableField("regeneration_mp_min")
    private Double regenerationMpMin;
    @TableField("regeneration_mp_max")
    private Double regenerationMpMax;
    @TableField("add_hp_min")
    private Integer addHpMin;
    @TableField("add_hp_max")
    private Integer addHpMax;
    @TableField("add_mp_min")
    private Integer addMpMin;
    @TableField("add_mp_max")
    private Integer addMpMax;
    @TableField("run_speed_min")
    private Double runSpeedMin;
    @TableField("run_speed_max")
    private Double runSpeedMax;
}
