package com.queue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.queue.entity.RoleUser;
import com.queue.entity.dto.SysUserDto;
import com.queue.entity.vo.UserSearchVo;

import java.util.List;
import java.util.Set;

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

    /**
     * 依据ID获取角色
     * @param id
     * @return
     */
    Set<String> getUserRoles(String id);

    /**
     * 依据ID获取权限
     * @param id
     * @return
     */
    Set<String> getUserPermissions(String id);
}
