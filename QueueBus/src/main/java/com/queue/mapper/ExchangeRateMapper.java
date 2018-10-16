package com.queue.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.queue.entity.ExchangeRate;

import java.util.List;

public interface ExchangeRateMapper extends BaseMapper<ExchangeRate> {

    List<ExchangeRate> searchExchangeByPage();
}