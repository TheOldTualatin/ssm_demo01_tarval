package com.yqx.ssm.service;

import com.yqx.ssm.domain.Syslog;
import org.springframework.stereotype.Service;

/**
 * @author YangQX   2022/3/31 - 20:19
 */
public interface ISysLogService
{
    public void save(Syslog syslog);
}
