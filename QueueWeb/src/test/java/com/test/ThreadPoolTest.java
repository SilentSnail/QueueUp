package com.test;

import com.queue.mail.send.SendMailPool;
import com.test.tool.PoolSendTest;
import com.test.tool.SendMailTest;

/**
 * Created by liusong on 2018/6/28.
 */
public class ThreadPoolTest {

    private static SendMailPool pool = new SendMailPool();

    public static void main(String[] args) {
        new Thread(new PoolSendTest(pool)).start();//执行
        new Thread(new SendMailTest(pool)).start();//添加
    }
}
