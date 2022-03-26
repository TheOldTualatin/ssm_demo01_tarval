package com.yqx.ssm.service;

import com.yqx.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author YangQX   2022/3/23 - 13:42
 */
public interface IUserService extends UserDetailsService
{
    List<UserInfo> findAll() throws Exception;

    UserInfo findById(String id) throws Exception;

    void save(UserInfo userInfo) throws Exception;
}
