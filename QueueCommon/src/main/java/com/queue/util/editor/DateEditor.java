package com.queue.util.editor;

import com.queue.util.DateUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * Created by liusong on 2018/10/27.
 */
public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(StringUtils.hasText(text)){
            try {
                super.setValue(DateUtils.parseDateTime(text));
            } catch (Exception e) {
                System.out.println(text);
                System.out.println(e.getMessage());
            }
        }else {
            super.setValue(null);
        }
    }

    @Override
    public String getAsText() {
        return getValue().toString();
    }
}
