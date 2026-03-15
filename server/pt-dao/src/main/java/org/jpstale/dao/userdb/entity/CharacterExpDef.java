package org.jpstale.dao.userdb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName(schema = "userdb", value = "character_exp_def")
public class CharacterExpDef {

    @TableField("level")
    private Integer level;
    @TableField("exp_required")
    private Long expRequired;
}
