package com.queue.controller;

import com.queue.utils.RedisUtils;
import com.queue.utils.SecurityEncryptUtils;
import com.queue.utils.SerializeUtils;
import com.queue.utils.editor.LocalDateEditor;
import com.queue.utils.editor.LocalDateTimeEditor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by liusong on 2018/10/27.
 */
public class BaseController {

    protected Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    private RedisUtils<String, byte[]> redisUtils;

    /**
     * 收到参数的时候 初始化
     * @param binder
     */
    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
        binder.registerCustomEditor(LocalDateTime.class, new LocalDateTimeEditor());
    }

    /**
     * 加入
     * @param content
     * @return
     */
    protected String setObject(Class content){
        String uuid = SecurityEncryptUtils.getUUID();
        this.redisUtils.setValue(uuid, SerializeUtils.toSerialize(content));
        return uuid;
    }
}
