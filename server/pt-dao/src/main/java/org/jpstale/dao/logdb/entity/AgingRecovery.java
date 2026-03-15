package org.jpstale.dao.logdb.entity;

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
@TableName(schema = "logdb", value = "aging_recovery")
public class AgingRecovery {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("account_name")
    private String accountName;
    @TableField("character_id")
    private Integer characterId;
    @TableField("date")
    private LocalDateTime date;
    @TableField("item_name")
    private String itemName;
    @TableField("age_number")
    private Integer ageNumber;
    @TableField("code1")
    private Integer code1;
    @TableField("code2")
    private Integer code2;
    @TableField("date_recovered")
    private LocalDateTime dateRecovered;
}
