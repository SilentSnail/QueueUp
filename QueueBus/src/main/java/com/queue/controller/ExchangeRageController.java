package com.queue.controller;

import com.queue.service.ExchangeRateService;
import com.queue.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusong on 2018/4/10.
 */
@RestController
@RequestMapping("/exchange")
public class ExchangeRageController {

    @Autowired
    private ExchangeRateService exchangeService;

    @RequestMapping("/getExchangeByPage")
    public R getExchangeByPage(){
        return R.ok(this.exchangeService.selectById(12));
    }
}
