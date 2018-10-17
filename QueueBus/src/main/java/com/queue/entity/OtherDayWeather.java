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
public class OtherDayWeather extends Model<OtherDayWeather> {

    private static final long serialVersionUID = 1L;

        /**
     * 天气ID
     */
         @TableId(value = "ODW_ID", type = IdType.AUTO)
    private Long odwId;

        /**
     * 关联Code
     */
         private String tIdentity;

        /**
     * 其他日期名称
     */
         private String odwDay;

        /**
     * 气温
     */
         private String temperature;

        /**
     * 天气情况
     */
         private String odwWeather;

        /**
     * 风力情况
     */
         private String windDirection;

        /**
     * 每周天数
     */
         private String odwWeek;

        /**
     * 创建时间
     */
         private LocalDateTime createTime;


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
        this.tIdentity = tIdentity;
        return this;
    }

    public String getOdwDay() {
        return odwDay;
    }

    public OtherDayWeather setOdwDay(String odwDay) {
        this.odwDay = odwDay;
        return this;
    }

    public String getTemperature() {
        return temperature;
    }

    public OtherDayWeather setTemperature(String temperature) {
        this.temperature = temperature;
        return this;
    }

    public String getOdwWeather() {
        return odwWeather;
    }

    public OtherDayWeather setOdwWeather(String odwWeather) {
        this.odwWeather = odwWeather;
        return this;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public OtherDayWeather setWindDirection(String windDirection) {
        this.windDirection = windDirection;
        return this;
    }

    public String getOdwWeek() {
        return odwWeek;
    }

    public OtherDayWeather setOdwWeek(String odwWeek) {
        this.odwWeek = odwWeek;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public OtherDayWeather setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.odwId;
    }

    @Override
    public String toString() {
        return "OtherDayWeather{" +
        "odwId=" + odwId +
        ", tIdentity=" + tIdentity +
        ", odwDay=" + odwDay +
        ", temperature=" + temperature +
        ", odwWeather=" + odwWeather +
        ", windDirection=" + windDirection +
        ", odwWeek=" + odwWeek +
        ", createTime=" + createTime +
        "}";
    }
}
