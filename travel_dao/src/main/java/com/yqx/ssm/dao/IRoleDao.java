package com.yqx.ssm.dao;

import com.yqx.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
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

    /**
     * 查询所有角色
     * @return 角色列表
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    /**
     * 添加角色
     * @throws Exception
     */
    @Insert("insert into role(id, roleName, roleDesc) VALUES (#{id}, #{roleName}, #{roleDesc});")
    void save(Role role) throws Exception;
}
