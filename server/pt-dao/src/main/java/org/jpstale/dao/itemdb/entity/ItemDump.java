package org.jpstale.dao.itemdb.entity;

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
@TableName(schema = "itemdb", value = "item_dump")
public class ItemDump {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("account_name")
    private String accountName;
    @TableField("char_name")
    private String charName;
    @TableField("item_name")
    private String itemName;
    @TableField("item_level")
    private Integer itemLevel;
    @TableField("item_id")
    private Integer itemId;
    @TableField("item_type_id")
    private Integer itemTypeId;
    @TableField("item_base_id")
    private Integer itemBaseId;
    @TableField("item_header")
    private Integer itemHeader;
    @TableField("item_checksum")
    private Integer itemChecksum;
    @TableField("item_backup_header")
    private Integer itemBackupHeader;
    @TableField("item_backup_checksum")
    private Integer itemBackupChecksum;
    @TableField("mix_effect")
    private Integer mixEffect;
    @TableField("mix_id")
    private Integer mixId;
    @TableField("age_level")
    private Integer ageLevel;
    @TableField("attack_range")
    private Integer attackRange;
    @TableField("attack_speed")
    private Integer attackSpeed;
    @TableField("attack_rating")
    private Integer attackRating;
    @TableField("atk_pow_min")
    private Short atkPowMin;
    @TableField("atk_pow_max")
    private Short atkPowMax;
    @TableField("critical")
    private Integer critical;
    @TableField("absorb")
    private Double absorb;
    @TableField("defense")
    private Integer defense;
    @TableField("block")
    private Double block;
    @TableField("organic")
    private Short organic;
    @TableField("fire")
    private Short fire;
    @TableField("frost")
    private Short frost;
    @TableField("lighting")
    private Short lighting;
    @TableField("poison")
    private Short poison;
    @TableField("strength_req")
    private Integer strengthReq;
    @TableField("spirit_req")
    private Integer spiritReq;
    @TableField("talent_req")
    private Integer talentReq;
    @TableField("agility_req")
    private Integer agilityReq;
    @TableField("health_req")
    private Integer healthReq;
    @TableField("mp_regen")
    private Double mpRegen;
    @TableField("hp_regen")
    private Double hpRegen;
    @TableField("sp_regen")
    private Double spRegen;
    @TableField("add_hp")
    private Double addHp;
    @TableField("add_mp")
    private Double addMp;
    @TableField("add_sp")
    private Double addSp;
    @TableField("item_spec")
    private Integer itemSpec;
    @TableField("spec_absorb")
    private Double specAbsorb;
    @TableField("spec_def")
    private Integer specDef;
    @TableField("spec_block_rating")
    private Double specBlockRating;
    @TableField("spec_attack_speed")
    private Integer specAttackSpeed;
    @TableField("spec_critical")
    private Integer specCritical;
    @TableField("spec_attack_rating_div")
    private Short specAttackRatingDiv;
    @TableField("spec_attack_power_div")
    private Short specAttackPowerDiv;
    @TableField("spec_mp_regen")
    private Double specMpRegen;
    @TableField("spec_hp_regen")
    private Double specHpRegen;
    @TableField("spec_sp_regen")
    private Double specSpRegen;
    @TableField("item_unique_id")
    private Integer itemUniqueId;
    @TableField("sale_price")
    private Integer salePrice;
    @TableField("created_date")
    private Integer createdDate;
}
