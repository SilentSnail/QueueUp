package com.queue.utils;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 文件读取工具类
 * Created by liusong on 2018/5/2.
 */
public class FileUtils {

    /**
     * 获取文件头，默认头8位
     * @param stream
     * @return
     */
    public static String getFileHeader(InputStream stream) throws IOException {
        return FileUtils.getFileHeader(stream, 8);
    }

    /**
     * 获取指定结束位置的Hex码 从0开始
     * @param stream
     * @param length
     * @return
     * @throws IOException
     */
    public static String getFileHeader(InputStream stream, Integer length) throws IOException {
        return FileUtils.getFileHeader(stream, 0, length);
    }

    /**
     * 获取指定位置开始，指定位置结束的Hex码
     * @param stream
     * @param start
     * @param length
     * @return
     * @throws IOException
     */
    public static String getFileHeader(InputStream stream, Integer start, Integer length) throws IOException {
        byte[] bytes = ArrayUtils.subarray(StreamUtils.InputStreamToBytes(stream), start, length);
        StringBuilder builder = new StringBuilder();
        if(bytes == null || bytes.length <= 0){
            return null;
        }
        String str;
        for (byte b : bytes) {
            str = Integer.toHexString(b & 0xFF).toUpperCase();
            if(str.length() < 2){
                builder.append(0);
            }
            builder.append(str);
        }
        return builder.toString();
    }

    /**
     * 追加写入文件
     * @param filePath 文件路径
     * @param context 写入内容
     */
    public static void writeFileToPath(String filePath, String context) {
        File file = new File(filePath);
        BufferedWriter out = null;
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            out = new BufferedWriter(new FileWriter(file, true));
            out.write("\r\n");
            out.write(context);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 重命名文件
     * @param oldFileName
     * @return
     */
    public static String getNewFileName(String oldFileName){
        StringBuffer str = new StringBuffer();
        synchronized (oldFileName){
            str.append(SecurityEncryptUtils.getUUID());
            try {
                str.append(oldFileName.substring(oldFileName.lastIndexOf("."), oldFileName.length()));
            } catch (Exception e) {
                str = new StringBuffer();
            }
            return str.toString();
        }
    }

    /**
     * 文件路径转换（有种多此一举的感觉）
     * @param path 文件路径
     * @return 格式化后的文件路径
     */
    public static String convertFilePath(String path){
        StringBuffer newPath = new StringBuffer();
        synchronized (newPath){
            String[] names;
            if(path.indexOf("\\") == -1){
                names = path.split("/");
                newPath.append("/");
            }else{
                names = path.split("\\\\");
            }
            for (String name : names) {
                if(ObjectUtils.isEmpty(name)){
                    continue;
                }
                newPath.append(name);
                newPath.append(File.separator);
            }
            return newPath.toString();
        }
    }

    /**
     * spring文件上传
     * @param file
     * @param savePath
     * @throws IOException
     */
    public static String saveFile(MultipartFile file, String savePath) throws IOException {
        if(file.isEmpty()){
            throw new FileNotFoundException("文件为空");
        }
        String saveName = FileUtils.getNewFileName(file.getOriginalFilename());
        if(ObjectUtils.isEmpty(saveName)){
            throw new RuntimeException("文件名错误");
        }
        savePath = convertFilePath(savePath);
        File saveFile = new File(savePath + saveName);
        if(!saveFile.exists()){
            saveFile.mkdirs();
        }
        file.transferTo(saveFile);
        return saveName;
    }
}
