package org.jpstale.dao.chatdb.mapper;

import org.jpstale.dao.chatdb.entity.GameMasterCommand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pt-dao
 * @since 2026-03-15
 */
public interface GameMasterCommandMapper extends BaseMapper<GameMasterCommand> {

    int insertGameMasterCommand(GameMasterCommand entity);

}
