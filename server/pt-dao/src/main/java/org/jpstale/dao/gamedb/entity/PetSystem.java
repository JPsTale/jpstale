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
@TableName(schema = "gamedb", value = "pet_system")
public class PetSystem {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("pet_owner_name")
    private String petOwnerName;
    @TableField("pet_name")
    private String petName;
    @TableField("pet_skin_id")
    private Integer petSkinId;
}
