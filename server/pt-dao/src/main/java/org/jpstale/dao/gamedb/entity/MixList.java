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
@TableName(schema = "gamedb", value = "mix_list")
public class MixList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("mix_unique_id")
    private Integer mixUniqueId;
    @TableField("group_mix_id")
    private Integer groupMixId;
    @TableField("type_mix")
    private Integer typeMix;
    @TableField("type_mix_name")
    private String typeMixName;
    @TableField("description")
    private String description;
    @TableField("lucidy")
    private Integer lucidy;
    @TableField("sereneo")
    private Integer sereneo;
    @TableField("fadeo")
    private Integer fadeo;
    @TableField("sparky")
    private Integer sparky;
    @TableField("raident")
    private Integer raident;
    @TableField("transparo")
    private Integer transparo;
    @TableField("murky")
    private Integer murky;
    @TableField("devine")
    private Integer devine;
    @TableField("celesto")
    private Integer celesto;
    @TableField("mirage")
    private Integer mirage;
    @TableField("inferna")
    private Integer inferna;
    @TableField("enigma")
    private Integer enigma;
    @TableField("bellum")
    private Integer bellum;
    @TableField("oredo")
    private Integer oredo;
    @TableField("new_sheltom14")
    private Integer newSheltom14;
    @TableField("new_sheltom15")
    private Integer newSheltom15;
    @TableField("type_atributte")
    private Integer typeAtributte;
    @TableField("atributte")
    private Double atributte;
    @TableField("per_atributte")
    private Integer perAtributte;
    @TableField("type_atributte2")
    private Integer typeAtributte2;
    @TableField("atributte2")
    private Double atributte2;
    @TableField("per_atributte2")
    private Integer perAtributte2;
    @TableField("type_atributte3")
    private Integer typeAtributte3;
    @TableField("atributte3")
    private Double atributte3;
    @TableField("per_atributte3")
    private Integer perAtributte3;
    @TableField("type_atributte4")
    private Integer typeAtributte4;
    @TableField("atributte4")
    private Double atributte4;
    @TableField("per_atributte4")
    private Integer perAtributte4;
    @TableField("type_atributte5")
    private Integer typeAtributte5;
    @TableField("atributte5")
    private Double atributte5;
    @TableField("per_atributte5")
    private Integer perAtributte5;
    @TableField("type_atributte6")
    private Integer typeAtributte6;
    @TableField("atributte6")
    private Double atributte6;
    @TableField("per_atributte6")
    private Integer perAtributte6;
    @TableField("type_atributte7")
    private Integer typeAtributte7;
    @TableField("atributte7")
    private Double atributte7;
    @TableField("per_atributte7")
    private Integer perAtributte7;
    @TableField("type_atributte8")
    private Integer typeAtributte8;
    @TableField("atributte8")
    private Double atributte8;
    @TableField("per_atributte8")
    private Integer perAtributte8;
}
