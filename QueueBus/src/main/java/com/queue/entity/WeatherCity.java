package com.queue.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

/**
 * 天气城市信息
 */
public class WeatherCity extends Model<WeatherCity> {

    private Long identity;
    private String cityId;
    private String cityName;
    private Short cityStatus;
    private Short delStatus;

    public Long getIdentity() {
        return identity;
    }

    public WeatherCity setIdentity(Long identity) {
        this.identity = identity;
        return this;
    }

    public String getCityId() {
        return cityId;
    }

    public WeatherCity setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public WeatherCity setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
        return this;
    }

    public Short getCityStatus() {
        return cityStatus;
    }

    public WeatherCity setCityStatus(Short cityStatus) {
        this.cityStatus = cityStatus;
        return this;
    }

    public Short getDelStatus() {
        return delStatus;
    }

    public WeatherCity setDelStatus(Short delStatus) {
        this.delStatus = delStatus;
        return this;
    }

    protected Serializable pkVal() {
        return this.identity;
    }
}