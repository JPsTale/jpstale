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
@TableName(schema = "gamedb", value = "model_animation_list")
public class ModelAnimationList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("model_id")
    private Integer modelId;
    @TableField("type")
    private Integer type;
    @TableField("frame_begin")
    private Integer frameBegin;
    @TableField("frame_end")
    private Integer frameEnd;
    @TableField("frame_event1")
    private Integer frameEvent1;
    @TableField("frame_event2")
    private Integer frameEvent2;
    @TableField("frame_event3")
    private Integer frameEvent3;
    @TableField("frame_event4")
    private Integer frameEvent4;
}
