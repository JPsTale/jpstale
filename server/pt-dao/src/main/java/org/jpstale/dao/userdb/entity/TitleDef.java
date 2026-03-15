package org.jpstale.dao.userdb.entity;

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
@TableName(schema = "userdb", value = "title_def")
public class TitleDef {

    @TableId("title_id")
    private Integer titleId;
    @TableField("title_category")
    private String titleCategory;
    @TableField("sub_category")
    private String subCategory;
    @TableField("title")
    private String title;
    @TableField("title_rarity")
    private Short titleRarity;
}
