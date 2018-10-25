package com.queue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.queue.entity.RoleUser;
import com.queue.entity.dto.SysUserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
public interface RoleUserMapper extends BaseMapper<RoleUser> {

    List<SysUserDto> getUserByParam(RoleUser user);

    void changePassword(@Param("userId") Long id,@Param("password") String password);
}
