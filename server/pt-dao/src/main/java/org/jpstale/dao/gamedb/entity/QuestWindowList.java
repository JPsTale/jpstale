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
@TableName(schema = "gamedb", value = "quest_window_list")
public class QuestWindowList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("npc_id")
    private Integer npcId;
    @TableField("quest_list_id")
    private String questListId;
    @TableField("main_image")
    private String mainImage;
    @TableField("main_text")
    private String mainText;
}
