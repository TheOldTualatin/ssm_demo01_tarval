package com.yqx.ssm.dao;

import com.yqx.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author YangQX   2022/3/23 - 16:51
 */
@Repository
public interface IUserDao
{
    @Select("select * from users where username=#{username}")
    @Results(
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.yqx.ssm.dao.IRoleDao.findBoleByUserId"))
    )
    UserInfo findByUsername(String username) throws Exception;
}
