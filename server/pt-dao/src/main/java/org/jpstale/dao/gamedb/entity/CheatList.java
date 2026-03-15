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
@TableName(schema = "gamedb", value = "cheat_list")
public class CheatList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("cheat_type")
    private Integer cheatType;
    @TableField("cheat_id")
    private Integer cheatId;
    @TableField("cheat_name")
    private String cheatName;
    @TableField("cheat_signature")
    private Integer cheatSignature;
}
