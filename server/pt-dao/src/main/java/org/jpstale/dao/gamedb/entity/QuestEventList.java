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
@TableName(schema = "gamedb", value = "quest_event_list")
public class QuestEventList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("quest_id")
    private Integer questId;
    @TableField("percent_increase_exp")
    private Integer percentIncreaseExp;
    @TableField("drop_reduction")
    private Integer dropReduction;
}
