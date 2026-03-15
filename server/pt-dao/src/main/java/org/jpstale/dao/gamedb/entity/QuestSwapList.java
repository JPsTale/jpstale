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
@TableName(schema = "gamedb", value = "quest_swap_list")
public class QuestSwapList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("quest_race1")
    private Integer questRace1;
    @TableField("quest_race2")
    private Integer questRace2;
    @TableField("quest_race3")
    private Integer questRace3;
}
