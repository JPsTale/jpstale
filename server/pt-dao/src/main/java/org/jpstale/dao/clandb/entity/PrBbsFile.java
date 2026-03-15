package org.jpstale.dao.clandb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName(schema = "clandb", value = "pr_bbs_file")
public class PrBbsFile {

    @TableField("idx")
    private Integer idx;
    @TableField("mindex")
    private Integer mindex;
    @TableField("file_name")
    private String fileName;
    @TableField("file_size")
    private String fileSize;
    @TableField("regi_date")
    private LocalDateTime regiDate;
}
