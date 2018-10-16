package com.queue.service;

import com.queue.entity.RoleUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liusong
 * @since 2018-10-16
 */
public interface RoleUserService extends IService<RoleUser> {

    List<RoleUser> getUserByParam(RoleUser user);

    void changePassword(Long id);
}
