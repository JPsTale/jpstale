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
@TableName(schema = "gamedb", value = "item_list_old")
public class ItemListOld {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("id_code")
    private Integer idCode;
    @TableField("name")
    private String name;
    @TableField("nullcode")
    private String nullcode;
    @TableField("code_img1")
    private String codeImg1;
    @TableField("code_img2")
    private String codeImg2;
    @TableField("width")
    private Integer width;
    @TableField("height")
    private Integer height;
    @TableField("drop_folder")
    private String dropFolder;
    @TableField("class_item")
    private Integer classItem;
    @TableField("model_position")
    private Integer modelPosition;
    @TableField("sound")
    private Integer sound;
    @TableField("weapon_class")
    private Integer weaponClass;
    @TableField("quest_id")
    private Integer questId;
    @TableField("quest_r")
    private Integer questR;
    @TableField("quest_g")
    private Integer questG;
    @TableField("quest_b")
    private Integer questB;
    @TableField("quest_transparency")
    private Integer questTransparency;
    @TableField("quest_flashing_time")
    private Integer questFlashingTime;
    @TableField("req_level")
    private Integer reqLevel;
    @TableField("req_strengh")
    private Integer reqStrengh;
    @TableField("req_spirit")
    private Integer reqSpirit;
    @TableField("req_talent")
    private Integer reqTalent;
    @TableField("req_agility")
    private Integer reqAgility;
    @TableField("req_health")
    private Integer reqHealth;
    @TableField("integrity_min")
    private Integer integrityMin;
    @TableField("integrity_max")
    private Integer integrityMax;
    @TableField("weight")
    private Integer weight;
    @TableField("price")
    private Integer price;
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
    @TableField("atk_pow1_min")
    private Integer atkPow1Min;
    @TableField("atk_pow1_max")
    private Integer atkPow1Max;
    @TableField("atk_pow2_min")
    private Integer atkPow2Min;
    @TableField("atk_pow2_max")
    private Integer atkPow2Max;
    @TableField("range")
    private Integer range;
    @TableField("atk_speed")
    private Integer atkSpeed;
    @TableField("atk_rating_min")
    private Integer atkRatingMin;
    @TableField("atk_rating_max")
    private Integer atkRatingMax;
    @TableField("critical")
    private Integer critical;
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
    @TableField("potion_space")
    private Integer potionSpace;
    @TableField("potion_count")
    private Integer potionCount;
    @TableField("regeneration_hp_min")
    private Double regenerationHpMin;
    @TableField("regeneration_hp_max")
    private Double regenerationHpMax;
    @TableField("regeneration_mp_min")
    private Double regenerationMpMin;
    @TableField("regeneration_mp_max")
    private Double regenerationMpMax;
    @TableField("regeneration_stm_min")
    private Double regenerationStmMin;
    @TableField("regeneration_stm_max")
    private Double regenerationStmMax;
    @TableField("add_hp_min")
    private Integer addHpMin;
    @TableField("add_hp_max")
    private Integer addHpMax;
    @TableField("add_mp_min")
    private Integer addMpMin;
    @TableField("add_mp_max")
    private Integer addMpMax;
    @TableField("add_stm_min")
    private Integer addStmMin;
    @TableField("add_stm_max")
    private Integer addStmMax;
    @TableField("recovery_hp_min")
    private Integer recoveryHpMin;
    @TableField("recovery_hp_max")
    private Integer recoveryHpMax;
    @TableField("recovery_mp_min")
    private Integer recoveryMpMin;
    @TableField("recovery_mp_max")
    private Integer recoveryMpMax;
    @TableField("recovery_stm_min")
    private Integer recoveryStmMin;
    @TableField("recovery_stm_max")
    private Integer recoveryStmMax;
    @TableField("run_speed_min")
    private Double runSpeedMin;
    @TableField("run_speed_max")
    private Double runSpeedMax;
    @TableField("primary_spec")
    private Integer primarySpec;
    @TableField("add_spec_class1")
    private Integer addSpecClass1;
    @TableField("add_spec_class2")
    private Integer addSpecClass2;
    @TableField("add_spec_class3")
    private Integer addSpecClass3;
    @TableField("add_spec_class4")
    private Integer addSpecClass4;
    @TableField("add_spec_class5")
    private Integer addSpecClass5;
    @TableField("add_spec_class6")
    private Integer addSpecClass6;
    @TableField("add_spec_class7")
    private Integer addSpecClass7;
    @TableField("add_spec_class8")
    private Integer addSpecClass8;
    @TableField("add_spec_class9")
    private Integer addSpecClass9;
    @TableField("add_spec_class10")
    private Integer addSpecClass10;
    @TableField("add_spec_class11")
    private Integer addSpecClass11;
    @TableField("add_spec_class12")
    private Integer addSpecClass12;
    @TableField("add_spec_run_speed_min")
    private Double addSpecRunSpeedMin;
    @TableField("add_spec_run_speed_max")
    private Double addSpecRunSpeedMax;
    @TableField("add_spec_absorb_min")
    private Double addSpecAbsorbMin;
    @TableField("add_spec_absorb_max")
    private Double addSpecAbsorbMax;
    @TableField("add_spec_defense_min")
    private Integer addSpecDefenseMin;
    @TableField("add_spec_defense_max")
    private Integer addSpecDefenseMax;
    @TableField("add_spec_atk_speed")
    private Integer addSpecAtkSpeed;
    @TableField("add_spec_critical")
    private Integer addSpecCritical;
    @TableField("add_spec_atk_power_min")
    private Integer addSpecAtkPowerMin;
    @TableField("add_spec_atk_power_max")
    private Integer addSpecAtkPowerMax;
    @TableField("add_spec_atk_rating_min")
    private Integer addSpecAtkRatingMin;
    @TableField("add_spec_atk_rating_max")
    private Integer addSpecAtkRatingMax;
    @TableField("add_spec_hp_regen")
    private Double addSpecHpRegen;
    @TableField("add_spec_mp_regen_min")
    private Double addSpecMpRegenMin;
    @TableField("add_spec_mp_regen_max")
    private Double addSpecMpRegenMax;
    @TableField("add_spec_stm_regen")
    private Double addSpecStmRegen;
    @TableField("add_spec_block")
    private Double addSpecBlock;
    @TableField("add_spec_range")
    private Integer addSpecRange;
    @TableField("cannot_drop")
    private Integer cannotDrop;
}
