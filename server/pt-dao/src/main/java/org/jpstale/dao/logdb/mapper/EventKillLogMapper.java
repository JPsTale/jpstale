package org.jpstale.dao.logdb.mapper;

import org.jpstale.dao.logdb.entity.EventKillLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pt-dao
 * @since 2026-03-15
 */
public interface EventKillLogMapper extends BaseMapper<EventKillLog> {

    int insertEventKillLog(EventKillLog entity);

}
