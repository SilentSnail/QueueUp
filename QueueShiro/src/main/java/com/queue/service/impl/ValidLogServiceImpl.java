package com.queue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.queue.entity.ValidLog;
import com.queue.mapper.ValidLogMapper;
import com.queue.service.ValidLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
@Service
public class ValidLogServiceImpl extends ServiceImpl<ValidLogMapper, ValidLog> implements ValidLogService {

    @Autowired
    private ValidLogMapper validLogMapper;

    public ValidLog searchByParam(Map<String, Object> param) {
        return this.validLogMapper.searchByParam(param);
    }

    public void saveValidByEntity(ValidLog valid) {
        this.validLogMapper.saveValidByEntity(valid);
    }
}
