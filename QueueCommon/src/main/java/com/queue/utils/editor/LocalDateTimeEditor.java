package com.queue.utils.editor;

import com.queue.utils.DateUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * 前端接收参数时，字符串自动转化为LocalDateTime
 * Created by liusong on 2018/10/27.
 */
public class LocalDateTimeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(StringUtils.hasText(text)){
            super.setValue(DateUtils.parseDateTime(text));
        } else {
            super.setValue(null);
        }
    }

    @Override
    public String getAsText() {
        return getValue().toString();
    }
}
