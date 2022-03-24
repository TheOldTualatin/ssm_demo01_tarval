package com.yqx.ssm.dao;

import com.yqx.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author YangQX   2022/3/23 - 16:51
 */
@Repository
public interface IUserDao
{
    @Select("select * from users where username=#{username}")
    UserInfo findByUsername(String username) throws Exception;
}
