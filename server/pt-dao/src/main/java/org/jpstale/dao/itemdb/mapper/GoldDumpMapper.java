package org.jpstale.dao.itemdb.mapper;

import org.jpstale.dao.itemdb.entity.GoldDump;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pt-dao
 * @since 2026-03-15
 */
public interface GoldDumpMapper extends BaseMapper<GoldDump> {

    int insertGoldDump(GoldDump entity);

    int deleteAll();

}
