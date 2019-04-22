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
 * @since 2019-04-18
 */
public class FileRecord extends Model<FileRecord> {

    private static final long serialVersionUID = 1L;

        /**
     * 唯一标识
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        /**
     * 文件编码
     */
         private String code;

        /**
     * 关联CODE
     */
         private String relationCode;

        /**
     * 未见标记类型
     */
         private String sign;

        /**
     * 上传文件名
     */
         private String uploadName;

        /**
     * 保存文件名
     */
         private String saveName;

        /**
     * 保存路径
     */
         private String path;

        /**
     * 状态 1:有效 0:无效
     */
         private Integer status;

        /**
     * 上传时间
     */
         private LocalDateTime createTime;

        /**
     * 上传人
     */
         private String userCode;


    public Long getId() {
        return id;
    }

    public FileRecord setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public FileRecord setCode(String code) {
        this.code = code;
        return this;
    }

    public String getRelationCode() {
        return relationCode;
    }

    public FileRecord setRelationCode(String relationCode) {
        this.relationCode = relationCode;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public FileRecord setSign(String sign) {
        this.sign = sign;
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

    public String getUserCode() {
        return userCode;
    }

    public FileRecord setUserCode(String userCode) {
        this.userCode = userCode;
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
        ", code=" + code +
        ", relationCode=" + relationCode +
        ", sign=" + sign +
        ", uploadName=" + uploadName +
        ", saveName=" + saveName +
        ", path=" + path +
        ", status=" + status +
        ", createTime=" + createTime +
        ", userCode=" + userCode +
        "}";
    }
}
