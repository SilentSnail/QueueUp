package com.queue.service.impl;

import com.queue.entity.WeatherCity;
import com.queue.mapper.WeatherCityMapper;
import com.queue.service.WeatherCityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
@Service
public class WeatherCityServiceImpl extends ServiceImpl<WeatherCityMapper, WeatherCity> implements WeatherCityService {

}
