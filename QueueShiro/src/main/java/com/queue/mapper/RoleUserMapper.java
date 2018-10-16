package com.queue.mapper;

import com.queue.entity.RoleUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liusong
 * @since 2018-10-16
 */
public interface RoleUserMapper extends BaseMapper<RoleUser> {

    List<RoleUser> getUserByParam(RoleUser user);

    void changePassword(Long id, String password);
}
