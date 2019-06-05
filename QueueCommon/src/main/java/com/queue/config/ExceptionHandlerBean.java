package com.queue.config;

import com.queue.utils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class ExceptionHandlerBean {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public R customExceptionHandler(Exception ex){
        ex.printStackTrace();
        return R.error(ex.getMessage());
    }
}
