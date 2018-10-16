package com.queue.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.queue.entity.ValidLog;

import java.util.Map;

/**
 * Created by liusong on 2018/10/12.
 */
public interface ValidLogMapper extends BaseMapper<ValidLog> {

    void insertByEntity(ValidLog valid);

    ValidLog searchByParam(Map<String, Object> param);
}
