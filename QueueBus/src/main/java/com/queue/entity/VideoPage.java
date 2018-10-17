package com.queue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
public class VideoPage extends Model<VideoPage> {

    private static final long serialVersionUID = 1L;

        /**
     * 页面ID
     */
         @TableId(value = "IDENTITY", type = IdType.AUTO)
    private String identity;

        /**
     * 标题
     */
         private String title;

        /**
     * 页面资源URL
     */
         private String pageUrl;

        /**
     * 视频ID
     */
         private Integer videoId;

        /**
     * 资源ID
     */
         private String sourceId;

        /**
     * 状态
     */
         private Integer status;

        /**
     * 创建时间
     */
         private LocalDateTime createTime;

        /**
     * 创建人
     */
         private String createBy;

        /**
     * 更新时间
     */
         private LocalDateTime updateTime;

        /**
     * 更新人
     */
         private String updateBy;

        /**
     * 资源评价
     */
         private String evaluate;

        /**
     * 备注
     */
         private String remark;

        /**
     * 是否VIP 0表示否 1表示 是
     */
         private Integer isVip;


    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    @Override
    protected Serializable pkVal() {
        return this.identity;
    }

    @Override
    public String toString() {
        return "VideoPage{" +
        "identity=" + identity +
        ", title=" + title +
        ", pageUrl=" + pageUrl +
        ", videoId=" + videoId +
        ", sourceId=" + sourceId +
        ", status=" + status +
        ", createTime=" + createTime +
        ", createBy=" + createBy +
        ", updateTime=" + updateTime +
        ", updateBy=" + updateBy +
        ", evaluate=" + evaluate +
        ", remark=" + remark +
        ", isVip=" + isVip +
        "}";
    }
}
