package com.queue.controller;

import com.queue.utils.R;
import com.queue.utils.RedisUtils;
import com.queue.utils.SecurityEncryptUtils;
import com.queue.utils.SerializeUtils;
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

    @RequestMapping("getCache")
    public R getCache(String key, String name){
        try {
            return R.ok(SerializeUtils.deSerialize(this.redisUtils.get(key), Class.forName(name)));
        } catch (ClassNotFoundException e) {
            return R.error("序列化错误");
        }
    }

    @RequestMapping("/cacheContent")
    public R setCache(String content){
        String uuid = SecurityEncryptUtils.getUUID();
        this.redisUtils.setValue(uuid, SerializeUtils.toSerialize(content));
        return R.ok(uuid);
    }
}