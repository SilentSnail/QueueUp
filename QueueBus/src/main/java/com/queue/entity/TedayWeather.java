package com.queue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
public class TedayWeather extends Model<TedayWeather> {

    private static final long serialVersionUID = 1L;

        /**
     * 天气ID
     */
         @TableId(value = "T_ID", type = IdType.AUTO)
    private Long tId;

        /**
     * 城市
     */
         private String crtCity;

        /**
     * 日期
     */
         private String crtDay;

        /**
     * 周天数
     */
         private String crtWeek;

        /**
     * 农历日期
     */
         private String curLunarDay;

        /**
     * PM2.5指数
     */
         private Integer pmExponent;

        /**
     * 当前气温
     */
         private Integer temperature;

        /**
     * 当前天气情况
     */
         private String crtWeather;

        /**
     * 整体气温
     */
         private String tedayTemperature;

        /**
     * 整体天气
     */
         private String tedayWeather;

        /**
     * 风力等级
     */
         private String windDirection;

        /**
     * 未来几天天气情况关联ID
     */
         private String tIdentity;

        /**
     * 创建时间
     */
         private LocalDateTime createTime;


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
        this.crtCity = crtCity;
        return this;
    }

    public String getCrtDay() {
        return crtDay;
    }

    public TedayWeather setCrtDay(String crtDay) {
        this.crtDay = crtDay;
        return this;
    }

    public String getCrtWeek() {
        return crtWeek;
    }

    public TedayWeather setCrtWeek(String crtWeek) {
        this.crtWeek = crtWeek;
        return this;
    }

    public String getCurLunarDay() {
        return curLunarDay;
    }

    public TedayWeather setCurLunarDay(String curLunarDay) {
        this.curLunarDay = curLunarDay;
        return this;
    }

    public Integer getPmExponent() {
        return pmExponent;
    }

    public TedayWeather setPmExponent(Integer pmExponent) {
        this.pmExponent = pmExponent;
        return this;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public TedayWeather setTemperature(Integer temperature) {
        this.temperature = temperature;
        return this;
    }

    public String getCrtWeather() {
        return crtWeather;
    }

    public TedayWeather setCrtWeather(String crtWeather) {
        this.crtWeather = crtWeather;
        return this;
    }

    public String getTedayTemperature() {
        return tedayTemperature;
    }

    public TedayWeather setTedayTemperature(String tedayTemperature) {
        this.tedayTemperature = tedayTemperature;
        return this;
    }

    public String getTedayWeather() {
        return tedayWeather;
    }

    public TedayWeather setTedayWeather(String tedayWeather) {
        this.tedayWeather = tedayWeather;
        return this;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public TedayWeather setWindDirection(String windDirection) {
        this.windDirection = windDirection;
        return this;
    }

    public String gettIdentity() {
        return tIdentity;
    }

    public TedayWeather settIdentity(String tIdentity) {
        this.tIdentity = tIdentity;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public TedayWeather setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.tId;
    }

    @Override
    public String toString() {
        return "TedayWeather{" +
        "tId=" + tId +
        ", crtCity=" + crtCity +
        ", crtDay=" + crtDay +
        ", crtWeek=" + crtWeek +
        ", curLunarDay=" + curLunarDay +
        ", pmExponent=" + pmExponent +
        ", temperature=" + temperature +
        ", crtWeather=" + crtWeather +
        ", tedayTemperature=" + tedayTemperature +
        ", tedayWeather=" + tedayWeather +
        ", windDirection=" + windDirection +
        ", tIdentity=" + tIdentity +
        ", createTime=" + createTime +
        "}";
    }
}
