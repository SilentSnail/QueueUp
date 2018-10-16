package com.queue.controller;

import com.queue.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusong on 2018/10/12.
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private RedisUtils<String, byte[]> redisUtils;

}