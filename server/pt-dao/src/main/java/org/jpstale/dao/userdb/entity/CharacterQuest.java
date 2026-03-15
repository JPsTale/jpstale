package org.jpstale.dao.userdb.entity;

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
@TableName(schema = "userdb", value = "character_quest")
public class CharacterQuest {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("quest_id")
    private Integer questId;
    @TableField("quest_reward_id")
    private Integer questRewardId;
    @TableField("character_id")
    private Integer characterId;
    @TableField("account_name")
    private String accountName;
    @TableField("character_name")
    private String characterName;
    @TableField("start_date")
    private LocalDateTime startDate;
    @TableField("end_date")
    private LocalDateTime endDate;
    @TableField("monster_count")
    private String monsterCount;
    @TableField("item_count")
    private String itemCount;
    @TableField("time_left")
    private Integer timeLeft;
    @TableField("counter")
    private Integer counter;
}
