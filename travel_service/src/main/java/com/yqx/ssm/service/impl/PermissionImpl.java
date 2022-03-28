package com.yqx.ssm.service.impl;

import com.yqx.ssm.dao.IPermissionsDao;
import com.yqx.ssm.domain.Permission;
import com.yqx.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YangQX   2022/3/28 - 18:03
 */

@Service
@Transactional
public class PermissionImpl implements IPermissionService
{

    @Autowired
    IPermissionsDao iPermissionsDao;
    @Override
    public List<Permission> findAll() throws Exception
    {
        return iPermissionsDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception
    {
        iPermissionsDao.save(permission);
    }
}
