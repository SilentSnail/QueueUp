package com.queue.util;

import java.io.IOException;
import java.io.InputStream;

/**
 * 字符串处理类
 * Created by liusong on 2018/5/2.
 */
public class StreamUtils {

    /**
     * 读取inputStream中的全部内容
     * @param stream
     * @return
     * @throws IOException
     */
    public static byte[] InputStreamToBytes(InputStream stream) throws IOException {
        int count = stream.available();
        byte[] bytes = new byte[count];
        stream.read(bytes);
        return bytes;
    }
}
