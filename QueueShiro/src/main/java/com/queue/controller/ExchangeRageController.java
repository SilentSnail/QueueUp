package com.queue.controller;

import com.queue.service.ExchangeRateService;
import com.queue.util.R;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusong on 2018/4/10.
 */
@RestController
@RequestMapping("/exchange")
public class ExchangeRageController {

    private static Logger log = LogManager.getLogger(ExchangeRageController.class);

    @Autowired
    private ExchangeRateService exchangeService;

    @RequestMapping("/getExchangeByPage")
    public R getExchangeByPage(){
        log.info("execute function success by getExchangeByPage");
        return R.ok("OK");
    }
}
