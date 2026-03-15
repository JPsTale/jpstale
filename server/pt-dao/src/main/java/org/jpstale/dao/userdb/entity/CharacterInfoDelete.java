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
@TableName(schema = "userdb", value = "character_info_delete")
public class CharacterInfoDelete {

    @TableId("id")
    private Integer id;
    @TableField("account_name")
    private String accountName;
    @TableField("name")
    private String name;
    @TableField("old_head")
    private String oldHead;
    @TableField("level")
    private Integer level;
    @TableField("experience")
    private Long experience;
    @TableField("gold")
    private Integer gold;
    @TableField("job_code")
    private Integer jobCode;
    @TableField("clan_id")
    private Integer clanId;
    @TableField("clan_permission")
    private Integer clanPermission;
    @TableField("clan_leave_date")
    private Integer clanLeaveDate;
    @TableField("last_seen_date")
    private String lastSeenDate;
    @TableField("bless_castle_score")
    private Integer blessCastleScore;
    @TableField("fsp")
    private Integer fsp;
    @TableField("last_stage")
    private Integer lastStage;
    @TableField("is_online")
    private Integer isOnline;
    @TableField("seasonal")
    private Integer seasonal;
    @TableField("gm_level")
    private Integer gmLevel;
    @TableField("banned")
    private Integer banned;
    @TableField("title")
    private Integer title;
    @TableField("dialog_skin")
    private Integer dialogSkin;
}
