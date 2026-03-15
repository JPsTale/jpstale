package org.jpstale.dao.skilldb.entity;

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
@TableName(schema = "skilldb", value = "enchant_weapon")
public class EnchantWeapon {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("skill_level")
    private Integer skillLevel;
    @TableField("fire_damage")
    private Integer fireDamage;
    @TableField("lightning_damage")
    private Integer lightningDamage;
    @TableField("ice_damage")
    private Integer iceDamage;
    @TableField("duration")
    private Integer duration;
    @TableField("mpusage")
    private Integer mpusage;
    @TableField("stmusage")
    private Integer stmusage;
    @TableField("create_time")
    private LocalDateTime createTime;
}
