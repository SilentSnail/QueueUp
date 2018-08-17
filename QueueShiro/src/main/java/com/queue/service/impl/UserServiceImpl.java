package com.queue.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.queue.entity.RoleUser;
import com.queue.mapper.RoleUserMapper;
import com.queue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liusong on 2018/4/9.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleUserMapper userMapper;

    public PageInfo<RoleUser> getUserByPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<RoleUser> users = userMapper.searchUserByPage();
        PageInfo<RoleUser> page = new PageInfo<RoleUser>(users);
        return page;
    }

    public RoleUser getUserByEntity(RoleUser user){
        return userMapper.getUserByEntity(user);
    }

    public int save(RoleUser user) {
        return userMapper.insert(user);
    }
}
