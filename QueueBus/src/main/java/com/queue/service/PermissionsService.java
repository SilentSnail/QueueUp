package com.queue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.queue.entity.Permissions;
import com.queue.entity.dto.PermissionDto;
import com.queue.entity.dto.PermissionListDto;
import com.queue.entity.dto.PrmsBaseListDto;
import com.queue.entity.vo.PermissionSearchVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liusong
 * @since 2019-04-23
 */
public interface PermissionsService extends IService<Permissions> {

    List<PermissionListDto> searchListByParam(PermissionSearchVo search);

    /**
     * 需要排除自身
     * @param name
     * @return
     */
    List<PrmsBaseListDto> searchListByName(String name);

    PermissionDto getPrmsInfoByCode(String code);
}
