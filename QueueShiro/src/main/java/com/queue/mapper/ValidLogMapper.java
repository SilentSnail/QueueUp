package com.queue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.queue.entity.ValidLog;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
public interface ValidLogMapper extends BaseMapper<ValidLog> {

    ValidLog searchByParam(Map<String, Object> param);

    void saveValidByEntity(ValidLog valid);
}
