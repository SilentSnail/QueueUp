package com.queue.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.queue.entity.ValidLog;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
public interface ValidLogService extends IService<ValidLog> {

    ValidLog searchByParam(Map<String, Object> param);
}
