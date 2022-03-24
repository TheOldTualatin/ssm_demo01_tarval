package com.yqx.ssm.service.impl;

import com.mysql.cj.log.Log;
import com.yqx.ssm.dao.IUserDao;
import com.yqx.ssm.domain.UserInfo;
import com.yqx.ssm.service.IUserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author YangQX   2022/3/23 - 13:42
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService
{
    @Autowired
    private IUserDao iUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserInfo userInfo = null;
        try
        {
            userInfo = iUserDao.findByUsername(username);
            System.out.println(userInfo);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
//        将自己的user对象封装成springSecurity对象
        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority());
//        Security底层会将用户名与密码进行配对，然后返回对应页面
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority()
    {
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        return list;
    }
}
