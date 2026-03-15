package org.jpstale.dao.clandb.mapper;

import org.apache.ibatis.annotations.Param;
import org.jpstale.dao.clandb.entity.Li;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pt-dao
 * @since 2026-03-15
 */
public interface LiMapper extends BaseMapper<Li> {

    Integer selectImgById(@Param("id") Integer id);
    int insertLi(Li entity);
    int updateImgById(@Param("id") Integer id, @Param("img") Integer img);

}
