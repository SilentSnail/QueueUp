package com.queue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.queue.entity.RoleUser;
import com.queue.entity.dto.SysUserDto;
import com.queue.entity.vo.UserSearchVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liusong
 * @since 2018-11-09
 */
public interface RoleUserMapper extends BaseMapper<RoleUser> {

    List<SysUserDto> getUserByParam(UserSearchVo search);
}
