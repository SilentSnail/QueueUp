package com.test.tool;

import java.util.List;
import java.util.Map;

/**
 * Created by liusong on 2018/10/11.
 */
public class UserInfo {

    private String name;
    private String six;
    private Integer age;
    private Double price;
    private List<Map<String, Object>> list;
    private Map<String,Object> map;
    private String[] array;
    private Long time;

    public UserInfo(String name) {
        this.name = name;
    }

    public UserInfo(String name, String six) {
        this.name = name;
        this.six = six;
    }

    public UserInfo(String name, String six, Integer age) {
        this.name = name;
        this.six = six;
        this.age = age;
    }

    public UserInfo(String name, String six, Integer age, Double price) {
        this.name = name;
        this.six = six;
        this.age = age;
        this.price = price;
    }

    public UserInfo(String name, String six, Integer age, Double price, List<Map<String, Object>> list) {
        this.name = name;
        this.six = six;
        this.age = age;
        this.price = price;
        this.list = list;
    }

    public UserInfo(String name, String six, Integer age, Double price, List<Map<String, Object>> list, Map<String, Object> map) {
        this.name = name;
        this.six = six;
        this.age = age;
        this.price = price;
        this.list = list;
        this.map = map;
    }

    public UserInfo(String name, String six, Integer age, Double price, List<Map<String, Object>> list, Map<String, Object> map, String[] array) {
        this.name = name;
        this.six = six;
        this.age = age;
        this.price = price;
        this.list = list;
        this.map = map;
        this.array = array;
    }

    public UserInfo(String name, String six, Integer age, Double price, List<Map<String, Object>> list, Map<String, Object> map, String[] array, Long time) {
        this.name = name;
        this.six = six;
        this.age = age;
        this.price = price;
        this.list = list;
        this.map = map;
        this.array = array;
        this.time = time;
    }
}
