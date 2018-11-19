package com.queue.controller;

import com.queue.utils.editor.LocalDateEditor;
import com.queue.utils.editor.LocalDateTimeEditor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by liusong on 2018/10/27.
 */
public class BaseController {

    protected Logger log = LogManager.getLogger(this.getClass());

    /**
     * 收到参数的时候 初始化
     * @param binder
     */
    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
        binder.registerCustomEditor(LocalDateTime.class, new LocalDateTimeEditor());
    }
}
