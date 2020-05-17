package com.queue.enums;

/**
 * Created by liusong on 2018/10/8.
 */
public enum FileType {

    XLS("D0CF11E0A1B11AE1", "xls"),
    XLSX("504B030414000600", "xls"),
    RAR("526172211A0700", "zip"),
    ZIP("504B0304140000", "zip"),
    DOCX("504b0304140006000800", "doc"),
    PNG("89504e470d0a1a0a0000", "image"),
    GIF("47494638396126026f01", "image"),
    JPEG("FFD8FFE000104A464946", "image");

    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private FileType(String type, String name) {
        this.type = type;
        this.name = name;
    }
}