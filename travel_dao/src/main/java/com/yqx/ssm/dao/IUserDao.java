package com.yqx.ssm.dao;

import com.yqx.ssm.domain.Role;
import com.yqx.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangQX   2022/3/23 - 16:51
 */
@Repository
public interface IUserDao
{
    /**
     * @param username 用户名称
     * @return 用户信息
     * @throws Exception
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.yqx.ssm.dao.IRoleDao.findBoleByUserId"))
    })
    UserInfo findByUsername(String username) throws Exception;

    /**
     * 查询所有用户
     *
     * @return 用户集合
     */
    @Select("select * from users")
    List<UserInfo> findAll();

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.yqx.ssm.dao.IRoleDao.findBoleByUserId"))
    })
    UserInfo findById(String id);

    @Insert("insert into users(id, email, username, PASSWORD, phoneNum, STATUS) values (#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId});")
    List<Role> findOtherRoles(String userId);

    /**
     * 根据Id添加角色
     * @param userId 用户ID
     * @param ids 角色Id集合
     */

    void addRoleToUser(@Param("userId") String userId,@Param("ids") String[] ids);
}
