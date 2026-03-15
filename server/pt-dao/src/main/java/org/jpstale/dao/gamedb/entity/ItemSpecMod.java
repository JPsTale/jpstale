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
@TableName(schema = "gamedb", value = "item_spec_mod")
public class ItemSpecMod {

    @TableId("add_spec_class01")
    private Integer addSpecClass01;
    @TableField("add_spec_class02")
    private Integer addSpecClass02;
    @TableField("add_spec_class03")
    private Integer addSpecClass03;
    @TableField("add_spec_class04")
    private Integer addSpecClass04;
    @TableField("add_spec_class05")
    private Integer addSpecClass05;
    @TableField("add_spec_class06")
    private Integer addSpecClass06;
    @TableField("add_spec_class07")
    private Integer addSpecClass07;
    @TableField("add_spec_class08")
    private Integer addSpecClass08;
    @TableField("add_spec_class09")
    private Integer addSpecClass09;
    @TableField("add_spec_class10")
    private Integer addSpecClass10;
    @TableField("item_type")
    private String itemType;
    @TableField("percent_req_strength")
    private Integer percentReqStrength;
    @TableField("percent_req_spirit")
    private Integer percentReqSpirit;
    @TableField("percent_req_talent")
    private Integer percentReqTalent;
    @TableField("percent_req_agility")
    private Integer percentReqAgility;
    @TableField("percent_req_health")
    private Integer percentReqHealth;
}
