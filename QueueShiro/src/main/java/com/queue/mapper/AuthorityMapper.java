package com.queue.mapper;

import com.queue.entity.Authority;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.queue.entity.dto.AuthorityInfoDto;
import com.queue.entity.dto.UserPermission;
import com.queue.entity.vo.AuthoritySearchVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liusong
 * @since 2019-05-11
 */
public interface AuthorityMapper extends BaseMapper<Authority> {

    List<AuthorityInfoDto> searchAuthorityList(AuthoritySearchVo search);

    List<UserPermission> searchPermissionByInfo(@Param("userId") Integer userCode, @Param("roleId") Integer roleId);
}
