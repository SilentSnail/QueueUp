package com.test.tool;

import com.queue.mail.send.SendMail;
import com.queue.mail.send.SendMailPool;

/**
 * Created by liusong on 2018/6/28.
 */
public class SendMailTest implements Runnable {

    private SendMailPool pool;

    public SendMailTest(SendMailPool send){
        this.pool = send;
    }

    public void run() {
        System.out.println("线程进入运行状态，开始为线程池添加线程");
        for (int i = 0; i < 100; i++) {
            if(this.pool.getRunnableSize() < 20){
                System.out.println("添加第：" + i + "个线程成功");
                this.pool.setRunnable(new SendMail());
            }else{
                while (this.pool.getRunnableSize() >= 20){
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("添加邮件任务结束");
    }

}
