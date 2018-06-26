package com.queue.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.util.DigestUtils;

/**
 * Created by liusong on 2018/6/1.
 */
public class EncryptionUtils {

    private static final String salt = "参与密码计算拼接";

    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    private static String encodeBase64(String body){
        return Base64.encodeToString(body.getBytes());
    }

    private static String decodeBase64(String code){
        return Base64.decodeToString(code);
    }

    private static String encodeHexCode(String body){
        return Hex.encodeToString(body.getBytes());
    }

    private static String decodeHexCode(String code){
        return new String(Hex.decode(code.getBytes()));
    }

    private static String shahash(String body){
        return new Sha256Hash(body, salt).toString();
    }

    public static String toMD5(String body){
        return DigestUtils.md5DigestAsHex((body + salt).getBytes());
    }

    public static void main(String[] args) {
        System.out.println(EncryptionUtils.toMD5("123456"));
    }
}
