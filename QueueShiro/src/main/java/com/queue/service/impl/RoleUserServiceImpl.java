package com.queue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.queue.entity.RoleUser;
import com.queue.entity.dto.SysUserDto;
import com.queue.entity.vo.UserSearchVo;
import com.queue.mapper.RoleUserMapper;
import com.queue.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusong
 * @since 2018-11-09
 */
@Service
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements RoleUserService {

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public List<SysUserDto> getUserByParam(UserSearchVo search) {
        return this.roleUserMapper.getUserByParam(search);
    }
}
