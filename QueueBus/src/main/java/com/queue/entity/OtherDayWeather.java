package com.queue.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 其他时间的天气情况
 */
public class OtherDayWeather extends Model<OtherDayWeather> {

    private Long odwId;
    private String tIdentity;
    private String odwDay;
    private String temperature;
    private String odwWeather;
    private String windDirection;
    private String odwWeek;
    private Date createTime;

    public Long getOdwId() {
        return odwId;
    }

    public OtherDayWeather setOdwId(Long odwId) {
        this.odwId = odwId;
        return this;
    }

    public String gettIdentity() {
        return tIdentity;
    }

    public OtherDayWeather settIdentity(String tIdentity) {
        this.tIdentity = tIdentity == null ? null : tIdentity.trim();
        return this;
    }

    public String getOdwDay() {
        return odwDay;
    }

    public OtherDayWeather setOdwDay(String odwDay) {
        this.odwDay = odwDay == null ? null : odwDay.trim();
        return this;
    }

    public String getTemperature() {
        return temperature;
    }

    public OtherDayWeather setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
        return this;
    }

    public String getOdwWeather() {
        return odwWeather;
    }

    public OtherDayWeather setOdwWeather(String odwWeather) {
        this.odwWeather = odwWeather == null ? null : odwWeather.trim();
        return this;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public OtherDayWeather setWindDirection(String windDirection) {
        this.windDirection = windDirection == null ? null : windDirection.trim();
        return this;
    }

    public String getOdwWeek() {
        return odwWeek;
    }

    public OtherDayWeather setOdwWeek(String odwWeek) {
        this.odwWeek = odwWeek == null ? null : odwWeek.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public OtherDayWeather setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    protected Serializable pkVal() {
        return this.odwId;
    }
}