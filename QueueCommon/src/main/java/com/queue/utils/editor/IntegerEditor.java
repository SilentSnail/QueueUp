package com.queue.utils.editor;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class IntegerEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(StringUtils.hasText(text)){
            super.setValue(Integer.parseInt(text));
        } else {
            super.setValue(null);
        }
    }

    @Override
    public String getAsText() {
        return super.getAsText().trim();
    }
}
