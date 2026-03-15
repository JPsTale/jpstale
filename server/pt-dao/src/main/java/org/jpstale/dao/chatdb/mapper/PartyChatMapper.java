package org.jpstale.dao.chatdb.mapper;

import org.jpstale.dao.chatdb.entity.PartyChat;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pt-dao
 * @since 2026-03-15
 */
public interface PartyChatMapper extends BaseMapper<PartyChat> {

    int insertPartyChat(PartyChat entity);

}
