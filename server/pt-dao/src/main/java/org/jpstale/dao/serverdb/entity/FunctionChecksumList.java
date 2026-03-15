package org.jpstale.dao.serverdb.entity;

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
@TableName(schema = "serverdb", value = "function_checksum_list")
public class FunctionChecksumList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("size")
    private Integer size;
    @TableField("address")
    private String address;
    @TableField("checksum")
    private String checksum;
}
