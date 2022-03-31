package com.yqx.ssm.dao;

import com.yqx.ssm.domain.Syslog;
import org.springframework.stereotype.Repository;

/**
 * @author YangQX   2022/3/31 - 20:20
 */
@Repository
public interface ISysLogDao
{
    void save(Syslog syslog);
}
