package com.queue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
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
public class ResourceUrl extends Model<ResourceUrl> {

    private static final long serialVersionUID = 1L;

        /**
     * 资源ID
     */
         @TableId(value = "IDENTITY", type = IdType.AUTO)
    private String identity;

        /**
     * 资源URL
     */
         private String sourceUrl;

        /**
     * 状态  1：有效  0：无效
     */
         private Integer status;

        /**
     * 评价
     */
         private String evaluate;

        /**
     * 下载次数
     */
         private Integer downloadCnt;

        /**
     * 创建时间
     */
         private LocalDateTime createTime;


    public String getIdentity() {
        return identity;
    }

    public ResourceUrl setIdentity(String identity) {
        this.identity = identity;
        return this;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public ResourceUrl setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ResourceUrl setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public ResourceUrl setEvaluate(String evaluate) {
        this.evaluate = evaluate;
        return this;
    }

    public Integer getDownloadCnt() {
        return downloadCnt;
    }

    public ResourceUrl setDownloadCnt(Integer downloadCnt) {
        this.downloadCnt = downloadCnt;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ResourceUrl setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.identity;
    }

    @Override
    public String toString() {
        return "ResourceUrl{" +
        "identity=" + identity +
        ", sourceUrl=" + sourceUrl +
        ", status=" + status +
        ", evaluate=" + evaluate +
        ", downloadCnt=" + downloadCnt +
        ", createTime=" + createTime +
        "}";
    }
}
