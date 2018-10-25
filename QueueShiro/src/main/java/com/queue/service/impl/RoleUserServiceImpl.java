package com.queue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.queue.entity.RoleUser;
import com.queue.entity.dto.SysUserDto;
import com.queue.mapper.RoleUserMapper;
import com.queue.service.RoleUserService;
import com.queue.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
@Service
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements RoleUserService {

    @Autowired
    private RoleUserMapper userMapper;

    public List<SysUserDto> getUserByParam(RoleUser user) {
        return this.userMapper.getUserByParam(user);
    }

    public void changePassword(Long id) {
        this.userMapper.changePassword(id, SecurityUtils.toMD5("123456"));
    }
}
