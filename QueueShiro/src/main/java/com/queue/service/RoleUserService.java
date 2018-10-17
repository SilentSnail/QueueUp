package com.queue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.queue.entity.RoleUser;

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
