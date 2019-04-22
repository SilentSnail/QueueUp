package com.queue.controller;

import com.queue.entity.FileRecord;
import com.queue.enums.FileType;
import com.queue.service.FileRecordService;
import com.queue.utils.FileUtils;
import com.queue.utils.R;
import com.queue.utils.SecurityEncryptUtils;
import com.queue.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by liusong on 2018/10/12.
 */
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController {

    String savePath = "/Volumes/TEST_HD/Temp/imgTmp";

    @Autowired
    private FileRecordService fileRecord;

    /**
     * 多文件上传
     * @param files
     * @return
     */
    @RequestMapping("/uploads")
    public R uploads(MultipartFile[] files){
        String[] uuids = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            FileRecord record;
            try {
                record = this.getFileRecord(file, FileUtils.convertFilePath(savePath), new FileRecord());
                this.fileRecord.save(record);
                uuids[i] = record.getCode();
            } catch (IOException e) {//错误处理应该由代理类去处理，此处暂时先这样
                log.error(e.getMessage());
                uuids[i] = "第 " + (i+1) + " 个文件出现错误，上传失败。错误信息：" + e.getMessage();
            }
        }
        return R.ok(uuids);
    }

    /**
     * 保存文件
     * @param file 保存的文件
     * @param savePath 保存文件路径
     * @param record 文件对象
     * @return 保存之后的文件记录对象
     * @throws IOException
     */
    private FileRecord getFileRecord(MultipartFile file, String savePath, FileRecord record) throws IOException {
        String code = SecurityEncryptUtils.getUUID();
        String saveName = FileUtils.saveFile(file, savePath);
        //保存文件记录
        record.setCode(code);
        record.setSign("image");
        record.setUploadName(file.getOriginalFilename());
        record.setSaveName(saveName);
        record.setPath(savePath + saveName);
        record.setUserCode(ShiroUtils.getLoginUser().getUserCode());
        return record;
    }

    /**
     * 单文件上传
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public R upload(MultipartFile file){
        try {
            String head = FileUtils.getFileHeader(file.getInputStream());
            if(FileUtils.checkFileType(FileType.XLSX, head)){
                return R.error("文件类型错误");
            }
            FileRecord record = this.getFileRecord(file, FileUtils.convertFilePath(savePath), new FileRecord());
            this.fileRecord.save(record);
            return R.ok(record.getCode());
        } catch (IOException e) {
            log.debug(e.getMessage());
            return R.error(e.getMessage());
        }
    }
}