package com.yqx.ssm.service.impl;

import com.yqx.ssm.dao.IRoleDao;
import com.yqx.ssm.domain.Role;
import com.yqx.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YangQX   2022/3/28 - 17:40
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService
{
    @Autowired
    private IRoleDao iRoleDao;
    @Override
    public List<Role> findAll() throws Exception
    {
        return iRoleDao.findAll();
    }
}
