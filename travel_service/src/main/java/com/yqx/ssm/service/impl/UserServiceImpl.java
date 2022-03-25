package com.yqx.ssm.service.impl;

import com.yqx.ssm.dao.IUserDao;
import com.yqx.ssm.domain.Role;
import com.yqx.ssm.domain.UserInfo;
import com.yqx.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangQX   2022/3/23 - 13:42
 */
@Service(value = "userService")
@Transactional
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
//        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        assert userInfo != null;
        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(), userInfo.getStatus() != 0,true,true,true,getAuthority(userInfo.getRoles()));
//        Security底层会将用户名与密码进行配对，然后返回对应页面
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles)
    {
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles)
        {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll()
    {
        return iUserDao.findAll();
    }

    @Override
    public UserInfo findById(String id)
    {
        return iUserDao.findById(id);
    }
}
