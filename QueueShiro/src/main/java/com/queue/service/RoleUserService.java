package com.queue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.queue.entity.RoleUser;
import com.queue.entity.dto.SysUserDto;
import com.queue.entity.vo.UserSearchVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liusong
 * @since 2018-11-09
 */
public interface RoleUserService extends IService<RoleUser> {

    /**
     * 获取用户信息
     * @param search
     * @return
     */
    List<SysUserDto> getUserByParam(UserSearchVo search);
}
