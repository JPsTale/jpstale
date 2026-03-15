package org.jpstale.dao.serverdb.entity;

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
@TableName(schema = "serverdb", value = "metadata")
public class Metadata {

    @TableId("key")
    private String key;
    @TableField("value")
    private Integer value;
    @TableField("is_public")
    private Integer isPublic;
}
