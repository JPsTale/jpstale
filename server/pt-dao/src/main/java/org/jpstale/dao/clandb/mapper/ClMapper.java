package org.jpstale.dao.clandb.mapper;

import org.apache.ibatis.annotations.Param;
import org.jpstale.dao.clandb.entity.Cl;
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
public interface ClMapper extends BaseMapper<Cl> {

    Cl selectIdClanZangMemCntByClanName(@Param("clanName") String clanName);
    String selectClanZangByClanName(@Param("clanName") String clanName);
    Integer selectIdByClanName(@Param("clanName") String clanName);
    Cl selectClanNameNoteByMIconCnt(@Param("mIconCnt") Integer mIconCnt);
    String selectClanZangByClanNameForCheck(@Param("clanName") String clanName);
    List<Cl> selectByClanNameOrderByCpointDesc();
    Cl selectClanZangMemCntNoteMIconCntRegiDateLimitDatePFlagKFlagClanMoneyByClanName(@Param("clanName") String clanName);
    int insertCl(Cl entity);
    int updateMemCntByClanName(@Param("memCnt") Integer memCnt, @Param("clanName") String clanName);
    int updateClanZangAndUserIdByClanName(@Param("clanZang") String clanZang, @Param("userId") String userId, @Param("clanName") String clanName);
    int deleteByClanName(@Param("clanName") String clanName);

}
