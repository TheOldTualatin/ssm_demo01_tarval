package com.yqx.ssm.dao;

import com.yqx.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangQX   2022/3/27 - 13:18
 */
@Repository
public interface IPermissionsDao
{
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    List<Permission> findRoleByRoleId(String id) throws Exception;

    /**
     * 查询所有权限
     */
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(id, permissionName, url) values (#{id}, #{permissionName}, #{url})")
    void save(Permission permission);
}
