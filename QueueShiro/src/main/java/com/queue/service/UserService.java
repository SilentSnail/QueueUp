package com.queue.service;

import com.github.pagehelper.PageInfo;
import com.queue.entity.RoleUser;

/**
 * Created by liusong on 2018/4/9.
 */
public interface UserService {

    PageInfo<RoleUser> getUserByPage(int pageNum, int pageSize);

    RoleUser getUserByEntity(RoleUser user);

    int save(RoleUser user);
}
