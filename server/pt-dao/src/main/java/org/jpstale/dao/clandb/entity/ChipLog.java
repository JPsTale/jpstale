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
@TableName(schema = "clandb", value = "chip_log")
public class ChipLog {

    @TableField("lg_idx")
    private Integer lgIdx;
    @TableField("cidx")
    private Integer cidx;
    @TableField("c_server")
    private Integer cServer;
    @TableField("user_id")
    private String userId;
    @TableField("ch_name")
    private String chName;
    @TableField("permi")
    private String permi;
    @TableField("regi_date")
    private LocalDateTime regiDate;
}
