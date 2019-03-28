package com.queue.enums;

/**
 * Created by liusong on 2018/10/8.
 */
public enum FileType {

    XLS("D0CF11E0A1B11AE1"),
    XLSX("504B030414000600"),
    RAR("526172211A0700"),
    ZIP("504B0304140000");

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private FileType(String type) {
        this.type = type;
    }
}