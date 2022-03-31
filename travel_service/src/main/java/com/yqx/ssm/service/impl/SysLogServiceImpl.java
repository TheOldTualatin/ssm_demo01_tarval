package com.yqx.ssm.service.impl;

import com.yqx.ssm.dao.ISysLogDao;
import com.yqx.ssm.domain.Syslog;
import com.yqx.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YangQX   2022/3/31 - 20:19
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService
{
    @Autowired
    private ISysLogDao iSysLogDao;

    @Override
    public void save(Syslog syslog)
    {
        iSysLogDao.save(syslog);
    }
}
