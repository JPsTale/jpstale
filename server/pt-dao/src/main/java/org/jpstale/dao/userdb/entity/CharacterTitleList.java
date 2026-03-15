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
@TableName(schema = "userdb", value = "character_title_list")
public class CharacterTitleList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("character_id")
    private Integer characterId;
    @TableField("title_id")
    private Integer titleId;
    @TableField("date_acquired")
    private LocalDateTime dateAcquired;
}
