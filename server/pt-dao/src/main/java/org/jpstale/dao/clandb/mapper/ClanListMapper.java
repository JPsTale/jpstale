package org.jpstale.dao.clandb.mapper;

import org.apache.ibatis.annotations.Param;
import org.jpstale.dao.clandb.entity.ClanList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pt-dao
 * @since 2026-03-15
 */
public interface ClanListMapper extends BaseMapper<ClanList> {

    List<ClanList> selectByAccountName(@Param("accountName") String accountName);
    String selectClanLeaderByClanName(@Param("clanName") String clanName);
    Integer selectIdByClanName(@Param("clanName") String clanName);
    int insertClanList(ClanList entity);
    int deleteByClanName(@Param("clanName") String clanName);

}
