package com.queue.service.impl;

import com.queue.entity.ForageType;
import com.queue.entity.dto.ForageNameDto;
import com.queue.entity.dto.ForageTypeDto;
import com.queue.entity.vo.ForageTypeSearchVo;
import com.queue.mapper.ForageTypeMapper;
import com.queue.service.ForageTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusong
 * @since 2019-06-18
 */
@Service
public class ForageTypeServiceImpl extends ServiceImpl<ForageTypeMapper, ForageType> implements ForageTypeService {

    @Autowired
    private ForageTypeMapper forageTypeMapper;

    @Override
    public List<ForageTypeDto> findByParam(ForageTypeSearchVo param) {
        return this.forageTypeMapper.findByParam(param);
    }

    @Override
    public List<ForageNameDto> findParnetByCode(String parentCode) {
        return this.forageTypeMapper.findParnetByCode(parentCode);
    }
}
