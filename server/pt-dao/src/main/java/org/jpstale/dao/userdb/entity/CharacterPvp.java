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
@TableName(schema = "userdb", value = "character_pvp")
public class CharacterPvp {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("character_name")
    private String characterName;
    @TableField("kills")
    private Integer kills;
    @TableField("deaths")
    private Integer deaths;
    @TableField("kill_streak")
    private Integer killStreak;
    @TableField("top_pvp")
    private Integer topPvp;
}
