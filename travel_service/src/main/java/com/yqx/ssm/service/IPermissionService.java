package com.yqx.ssm.service;

import com.yqx.ssm.domain.Permission;

import java.util.List;

/**
 * @author YangQX   2022/3/28 - 18:03
 */
public interface IPermissionService
{
    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
