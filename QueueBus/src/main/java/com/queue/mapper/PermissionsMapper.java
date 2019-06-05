package com.queue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.queue.entity.Permissions;
import com.queue.entity.dto.PermissionDto;
import com.queue.entity.dto.PermissionListDto;
import com.queue.entity.dto.PrmsBaseListDto;
import com.queue.entity.vo.PermissionSearchVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liusong
 * @since 2019-04-23
 */
public interface PermissionsMapper extends BaseMapper<Permissions> {

    List<PermissionListDto> searchListByParam(PermissionSearchVo search);

    List<PrmsBaseListDto> searchListByName(@Param("name") String name);

    PermissionDto getPrmsInfoByCode(@Param("code") String code);
}
