package com.test;

import com.queue.mail.util.SendMailPool;
import com.queue.utils.SecurityEncryptUtils;
import com.test.tool.PoolSendTest;
import com.test.tool.SendMailTest;

/**
 * Created by liusong on 2018/6/28.
 */
public class ThreadPoolTest {

    private SendMailPool pool = new SendMailPool();

    public static void main(String[] args) {
        System.out.println(SecurityEncryptUtils.getUUID());
        System.out.println(SecurityEncryptUtils.toMD5("leisana321"));
    }

    public void sendMailTest(){
        new Thread(new PoolSendTest(pool)).start();//执行
        new Thread(new SendMailTest(pool)).start();//添加
    }
}
