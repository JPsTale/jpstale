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
@TableName(schema = "gamedb", value = "pet_system_skin")
public class PetSystemSkin {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("pet_name_summon")
    private String petNameSummon;
    @TableField("pet_size")
    private Double petSize;
    @TableField("pet_rarity")
    private Integer petRarity;
}
