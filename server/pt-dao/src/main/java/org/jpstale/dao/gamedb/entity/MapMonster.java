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
@TableName(schema = "gamedb", value = "map_monster")
public class MapMonster {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("stage")
    private String stage;
    @TableField("max_monsters")
    private Integer maxMonsters;
    @TableField("interval")
    private Integer interval;
    @TableField("max_enemy_flag")
    private Integer maxEnemyFlag;
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
    @TableField("monster5")
    private String monster5;
    @TableField("count5")
    private Integer count5;
    @TableField("monster6")
    private String monster6;
    @TableField("count6")
    private Integer count6;
    @TableField("monster7")
    private String monster7;
    @TableField("count7")
    private Integer count7;
    @TableField("monster8")
    private String monster8;
    @TableField("count8")
    private Integer count8;
    @TableField("monster9")
    private String monster9;
    @TableField("count9")
    private Integer count9;
    @TableField("monster10")
    private String monster10;
    @TableField("count10")
    private Integer count10;
    @TableField("monster11")
    private String monster11;
    @TableField("count11")
    private Integer count11;
    @TableField("monster12")
    private String monster12;
    @TableField("count12")
    private Integer count12;
    @TableField("boss_monster1")
    private String bossMonster1;
    @TableField("hours_boss_monster1")
    private String hoursBossMonster1;
    @TableField("sub_monster1")
    private String subMonster1;
    @TableField("count_sub1")
    private Integer countSub1;
    @TableField("boss_monster2")
    private String bossMonster2;
    @TableField("hours_boss_monster2")
    private String hoursBossMonster2;
    @TableField("sub_monster2")
    private String subMonster2;
    @TableField("count_sub2")
    private Integer countSub2;
    @TableField("boss_monster3")
    private String bossMonster3;
    @TableField("hours_boss_monster3")
    private String hoursBossMonster3;
    @TableField("sub_monster3")
    private String subMonster3;
    @TableField("count_sub3")
    private Integer countSub3;
}
