package org.jpstale.dao.eventdb.entity;

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
@TableName(schema = "eventdb", value = "bellatra_monster")
public class BellatraMonster {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("round")
    private Integer round;
    @TableField("monster1")
    private String monster1;
    @TableField("count1")
    private Integer count1;
    @TableField("monster2")
    private String monster2;
    @TableField("count2")
    private Integer count2;
    @TableField("monster3")
    private String monster3;
    @TableField("count3")
    private Integer count3;
    @TableField("monster4")
    private String monster4;
    @TableField("count4")
    private Integer count4;
    @TableField("boss")
    private String boss;
    @TableField("boss_appear")
    private Integer bossAppear;
    @TableField("view_sight")
    private Integer viewSight;
    @TableField("start_round")
    private Integer startRound;
    @TableField("gold")
    private Integer gold;
    @TableField("delay_round")
    private Integer delayRound;
    @TableField("percent_monsters")
    private Integer percentMonsters;
    @TableField("max_monsters")
    private Integer maxMonsters;
}
