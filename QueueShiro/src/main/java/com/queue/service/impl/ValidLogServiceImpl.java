package com.queue.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.queue.entity.ValidLog;
import com.queue.mapper.ValidLogMapper;
import com.queue.service.ValidLogService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by liusong on 2018/10/12.
 */
@Service
public class ValidLogServiceImpl extends ServiceImpl<ValidLogMapper, ValidLog> implements ValidLogService {

    private static Logger log = LogManager.getLogger(ValidLogServiceImpl.class);

    @Autowired
    private ValidLogMapper validLogMapper;

    public void save(ValidLog valid) {
        this.validLogMapper.insert(valid);
    }

    public ValidLog searchByParam(Map<String, Object> param) {
        return this.validLogMapper.searchByParam(param);
    }
}
