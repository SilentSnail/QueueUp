package com.queue.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by liusong on 2018/5/2.
 */
public class StreamUtils {

    public static byte[] InputStreamToBytes(InputStream stream) throws IOException {
        int count = stream.available();
        byte[] bytes = new byte[count];
        stream.read(bytes);
        return bytes;
    }

    public synchronized static String getUUID(){
        return (UUID.randomUUID().toString()).replace("-", "");
    }
}
