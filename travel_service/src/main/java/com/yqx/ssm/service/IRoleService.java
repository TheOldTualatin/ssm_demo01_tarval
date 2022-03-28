package com.yqx.ssm.service;

import com.yqx.ssm.domain.Role;

import java.util.List;

/**
 * @author YangQX   2022/3/28 - 17:39
 */
public interface IRoleService
{
    /**
     * 查询所有角色信息
     * @return 返回角色列表
     * @throws Exception
     */
    List<Role> findAll() throws Exception;
}
