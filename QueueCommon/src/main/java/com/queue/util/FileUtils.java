package com.queue.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by liusong on 2018/5/2.
 */
public class FileUtils {

    public static final String FILE_HEAD_XLS = "D0CF11E0A1B11AE1";//Excel 2003文件头
    public static final String FILE_HEAD_XLSX = "504B030414000600";//Excel 2007文件头
    public static final String FILE_HEAD_RAR = "526172211A0700";//RAR压缩文件的文件头
    public static final String FILE_HEAD_ZIP = "504B0304140000";//ZIP压缩文件的文件头

    public static String getExcelHeader(byte[] b){
        return bytesToHexString(b);
    }

    private static String bytesToHexString(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        if(bytes == null || bytes.length <= 0){
            return null;
        }
        String str;
        for (byte b :bytes) {
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
    public synchronized static void writeStrToFile(String filePath, String context) {
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
}
