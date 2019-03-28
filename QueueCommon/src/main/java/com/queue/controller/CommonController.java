package com.queue.controller;

import com.queue.utils.FileUtils;
import com.queue.utils.R;
import com.queue.utils.RedisUtils;
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

    String savePath = "/Users/Shared/";

    /**
     * 多文件上传
     * @param files
     * @return
     */
    @RequestMapping("/uploads")
    public R uploads(MultipartFile[] files){
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            try {
                FileUtils.saveFile(file, savePath);
            } catch (IOException e) {//错误处理应该由代理类去处理，此处暂时先这样
                log.error(e.getMessage());
                return R.error("第 " + (i+1) + " 个文件出现错误，上传失败");
            }
        }
        return R.ok();
    }

    /**
     * 单文件上传
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public R upload(MultipartFile file){
        try {
            FileUtils.saveFile(file, savePath);
        } catch (IOException e) {
            log.error(e.getMessage());
            return R.error("上传失败");
        }
        return R.ok();
    }
}