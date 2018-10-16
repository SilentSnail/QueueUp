package com.queue.service;

import com.queue.entity.ValidLog;

import java.util.Map;

/**
 * Created by liusong on 2018/10/12.
 */
public interface ValidLogService {

    void save(ValidLog valid);

    ValidLog searchByParam(Map<String, Object> param);
}
