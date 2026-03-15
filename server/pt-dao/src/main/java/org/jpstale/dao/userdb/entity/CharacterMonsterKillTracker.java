package org.jpstale.dao.userdb.entity;

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
@TableName(schema = "userdb", value = "character_monster_kill_tracker")
public class CharacterMonsterKillTracker {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("character_id")
    private Integer characterId;
    @TableField("monster_id")
    private Integer monsterId;
    @TableField("monster_name")
    private String monsterName;
    @TableField("kill_count")
    private Integer killCount;
}
