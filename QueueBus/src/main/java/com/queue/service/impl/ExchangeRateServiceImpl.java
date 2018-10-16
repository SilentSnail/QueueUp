package com.queue.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.queue.entity.ExchangeRate;
import com.queue.mapper.ExchangeRateMapper;
import com.queue.service.ExchangeRateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liusong on 2018/4/10.
 */
@Service
public class ExchangeRateServiceImpl extends ServiceImpl<ExchangeRateMapper, ExchangeRate> implements ExchangeRateService{

    private static Logger log = LogManager.getLogger(ExchangeRateServiceImpl.class);

    @Autowired
    private ExchangeRateMapper exchangeMapper;

    public List<ExchangeRate> getExchangeByPage() {
        return exchangeMapper.searchExchangeByPage();
    }
}
