package org.jpstale.dao.userdb.mapper;

import org.apache.ibatis.annotations.Param;
import org.jpstale.dao.userdb.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pt-dao
 * @since 2026-03-15
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /** C++ accountserver.cpp GetSQLUserInfoData - 按账号名查一条 */
    UserInfo selectOneByAccountName(@Param("accountName") String accountName);

    /** 注册查重：按邮箱查一条（email 唯一键） */
    UserInfo selectOneByEmail(@Param("email") String email);

    /** C++ accountserver.cpp SQLUnbanAccountId */
    int updateUnbanById(@Param("id") Integer id);

    /** C++ accountserver.cpp SQLUnmuteAccountId */
    int updateUnmuteById(@Param("id") Integer id);

}
