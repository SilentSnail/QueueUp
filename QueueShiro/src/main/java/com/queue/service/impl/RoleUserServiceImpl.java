package com.queue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.queue.entity.RoleUser;
import com.queue.entity.dto.SysUserDto;
import com.queue.entity.vo.UserSearchVo;
import com.queue.mapper.RoleUserMapper;
import com.queue.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public Set<String> getUserRoles(String id) {
        return new LinkedHashSet<>();
    }

    @Override
    public Set<String> getUserPermissions(String id) {
        return new LinkedHashSet<>();
    }


}
