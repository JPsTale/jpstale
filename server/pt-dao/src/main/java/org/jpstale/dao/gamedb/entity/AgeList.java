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
@TableName(schema = "gamedb", value = "age_list")
public class AgeList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("age_number")
    private Integer ageNumber;
    @TableField("fail_chance")
    private Integer failChance;
    @TableField("plus2_chance")
    private Integer plus2Chance;
    @TableField("minus2_chance")
    private Integer minus2Chance;
    @TableField("minus1_chance")
    private Integer minus1Chance;
    @TableField("broken_chance")
    private Integer brokenChance;
    @TableField("age_stone")
    private Integer ageStone;
}
