package com.queue.service;

import com.baomidou.mybatisplus.service.IService;
import com.queue.entity.ExchangeRate;

import java.util.List;

/**
 * Created by liusong on 2018/4/10.
 */
public interface ExchangeRateService extends IService<ExchangeRate> {

    List<ExchangeRate> getExchangeByPage();

}
