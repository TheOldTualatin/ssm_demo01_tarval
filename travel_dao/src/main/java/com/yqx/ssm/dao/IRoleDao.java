package com.yqx.ssm.dao;

import com.yqx.ssm.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangQX   2022/3/25 - 16:26
 */
@Repository
public interface IRoleDao
{
    /**
     * 根据用户ID查询用户角色
     *
     * @param userId 用户ID
     * @return 用户角色列表
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId= #{userId});")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.yqx.ssm.dao.IPermissionsDao.findRoleByRoleId"))
    })
    List<Role> findBoleByUserId(String userId) throws Exception;
}
