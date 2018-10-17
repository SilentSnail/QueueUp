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
public class FileRecord extends Model<FileRecord> {

    private static final long serialVersionUID = 1L;

        /**
     * 文件ID
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        /**
     * 文件关联Code
     */
         private String relationCode;

        /**
     * 上传文件名
     */
         private String uploadName;

        /**
     * 文件保存名
     */
         private String saveName;

        /**
     * 保存路径
     */
         private String path;

        /**
     * 状态 1：有效  0：无效
     */
         private Integer status;

        /**
     * 创建时间
     */
         private LocalDateTime createTime;

        /**
     * 上传人
     */
         private String userName;


    public Long getId() {
        return id;
    }

    public FileRecord setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRelationCode() {
        return relationCode;
    }

    public FileRecord setRelationCode(String relationCode) {
        this.relationCode = relationCode;
        return this;
    }

    public String getUploadName() {
        return uploadName;
    }

    public FileRecord setUploadName(String uploadName) {
        this.uploadName = uploadName;
        return this;
    }

    public String getSaveName() {
        return saveName;
    }

    public FileRecord setSaveName(String saveName) {
        this.saveName = saveName;
        return this;
    }

    public String getPath() {
        return path;
    }

    public FileRecord setPath(String path) {
        this.path = path;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public FileRecord setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FileRecord setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public FileRecord setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "FileRecord{" +
        "id=" + id +
        ", relationCode=" + relationCode +
        ", uploadName=" + uploadName +
        ", saveName=" + saveName +
        ", path=" + path +
        ", status=" + status +
        ", createTime=" + createTime +
        ", userName=" + userName +
        "}";
    }
}
