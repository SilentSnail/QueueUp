package com.queue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
public class WeatherCity extends Model<WeatherCity> {

    private static final long serialVersionUID = 1L;

        /**
     * 天气城市ID
     */
         @TableId(value = "IDENTITY", type = IdType.AUTO)
    private Long identity;

        /**
     * 天气城市Code
     */
         private String cityId;

        /**
     * 天气城市名称
     */
         private String cityName;

        /**
     * 天气城市状态 1：有效 0：无效
     */
         private Integer cityStatus;

        /**
     * 是否删除 1：未删除  0：删除
     */
         private Integer delStatus;


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
        this.cityId = cityId;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public WeatherCity setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public Integer getCityStatus() {
        return cityStatus;
    }

    public WeatherCity setCityStatus(Integer cityStatus) {
        this.cityStatus = cityStatus;
        return this;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public WeatherCity setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.identity;
    }

    @Override
    public String toString() {
        return "WeatherCity{" +
        "identity=" + identity +
        ", cityId=" + cityId +
        ", cityName=" + cityName +
        ", cityStatus=" + cityStatus +
        ", delStatus=" + delStatus +
        "}";
    }
}
