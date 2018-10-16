package com.queue.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 当前的天气情况
 */
public class TedayWeather extends Model<TedayWeather> {

    private Long tId;

    private String crtCity;

    private String crtDay;

    private String crtWeek;

    private String curLunarDay;

    private Short pmExponent;

    private Short temperature;

    private String crtWeather;

    private String tedayTemperature;

    private String tedayWeather;

    private String windDirection;

    private String tIdentity;

    private Date createTime;

    public Long gettId() {
        return tId;
    }

    public TedayWeather settId(Long tId) {
        this.tId = tId;
        return this;
    }

    public String getCrtCity() {
        return crtCity;
    }

    public TedayWeather setCrtCity(String crtCity) {
        this.crtCity = crtCity == null ? null : crtCity.trim();
        return this;
    }

    public String getCrtDay() {
        return crtDay;
    }

    public TedayWeather setCrtDay(String crtDay) {
        this.crtDay = crtDay == null ? null : crtDay.trim();
        return this;
    }

    public String getCrtWeek() {
        return crtWeek;
    }

    public TedayWeather setCrtWeek(String crtWeek) {
        this.crtWeek = crtWeek == null ? null : crtWeek.trim();
        return this;
    }

    public String getCurLunarDay() {
        return curLunarDay;
    }

    public TedayWeather setCurLunarDay(String curLunarDay) {
        this.curLunarDay = curLunarDay == null ? null : curLunarDay.trim();
        return this;
    }

    public Short getPmExponent() {
        return pmExponent;
    }

    public TedayWeather setPmExponent(Short pmExponent) {
        this.pmExponent = pmExponent;
        return this;
    }

    public Short getTemperature() {
        return temperature;
    }

    public TedayWeather setTemperature(Short temperature) {
        this.temperature = temperature;
        return this;
    }

    public String getCrtWeather() {
        return crtWeather;
    }

    public TedayWeather setCrtWeather(String crtWeather) {
        this.crtWeather = crtWeather == null ? null : crtWeather.trim();
        return this;
    }

    public String getTedayTemperature() {
        return tedayTemperature;
    }

    public TedayWeather setTedayTemperature(String tedayTemperature) {
        this.tedayTemperature = tedayTemperature == null ? null : tedayTemperature.trim();
        return this;
    }

    public String getTedayWeather() {
        return tedayWeather;
    }

    public TedayWeather setTedayWeather(String tedayWeather) {
        this.tedayWeather = tedayWeather == null ? null : tedayWeather.trim();
        return this;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public TedayWeather setWindDirection(String windDirection) {
        this.windDirection = windDirection == null ? null : windDirection.trim();
        return this;
    }

    public String gettIdentity() {
        return tIdentity;
    }

    public TedayWeather settIdentity(String tIdentity) {
        this.tIdentity = tIdentity == null ? null : tIdentity.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public TedayWeather setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    protected Serializable pkVal() {
        return this.tId;
    }
}