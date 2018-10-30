package com.queue.controller;

import com.queue.util.editor.DateEditor;
import com.sun.beans.editors.LongEditor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.time.LocalDateTime;

/**
 * Created by liusong on 2018/10/27.
 */
public class BaseController {

    protected Logger log = LogManager.getLogger(this.getClass());

    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(LocalDateTime.class, new DateEditor());
        binder.registerCustomEditor(Long.class, new LongEditor());
    }
}
