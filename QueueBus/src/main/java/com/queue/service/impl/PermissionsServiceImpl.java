package com.queue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.queue.entity.Permissions;
import com.queue.entity.dto.PermissionDto;
import com.queue.entity.dto.PermissionListDto;
import com.queue.entity.dto.PrmsBaseListDto;
import com.queue.entity.vo.PermissionSearchVo;
import com.queue.mapper.PermissionsMapper;
import com.queue.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusong
 * @since 2019-04-23
 */
@Service
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions> implements PermissionsService {

    @Autowired
    private PermissionsMapper permissionsMapper;

    @Override
    public List<PermissionListDto> searchListByParam(PermissionSearchVo search) {
        return this.permissionsMapper.searchListByParam(search);
    }

    @Override
    public List<PrmsBaseListDto> searchListByName(String name) {
        return this.permissionsMapper.searchListByName(name);
    }

    @Override
    public PermissionDto getPrmsInfoByCode(String code) {
        return this.permissionsMapper.getPrmsInfoByCode(code);
    }
}
