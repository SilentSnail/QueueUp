package com.queue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.queue.entity.ValidLog;
import com.queue.mapper.ValidLogMapper;
import com.queue.service.ValidLogService;
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

    public ValidLog searchByParam(Map<String, Object> param) {
        return null;
    }
}
