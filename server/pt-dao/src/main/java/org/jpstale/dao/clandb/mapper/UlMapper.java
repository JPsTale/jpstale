package org.jpstale.dao.clandb.mapper;

import org.apache.ibatis.annotations.Param;
import org.jpstale.dao.clandb.entity.Ul;
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
public interface UlMapper extends BaseMapper<Ul> {

    String selectClanNameByChName(@Param("chName") String chName);
    Ul selectClanNameAndPermiByChName(@Param("chName") String chName);
    String selectChNameByPermi2AndClanName(@Param("clanName") String clanName);
    List<String> selectChNameListByClanName(@Param("clanName") String clanName);
    String selectUserIdByChNameAndClanName(@Param("chName") String chName, @Param("clanName") String clanName);
    Ul selectByChName(@Param("chName") String chName);
    int insertUl(Ul entity);
    int updatePermi0ByChName(@Param("chName") String chName);
    int updatePermi2ByChName(@Param("chName") String chName);
    int updatePermi0ByClanNameInChName(@Param("chName") String chName);
    int updateMIconCntByChName(@Param("chName") String chName, @Param("mIconCnt") Integer mIconCnt);
    int deleteByChName(@Param("chName") String chName);
    int deleteByClanName(@Param("clanName") String clanName);

}
