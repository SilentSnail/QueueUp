package com.test.tool;

import com.queue.mail.send.SendMailPool;

/**
 * Created by liusong on 2018/6/28.
 */
public class PoolSendTest implements Runnable {

    private SendMailPool pool;

    public PoolSendTest(SendMailPool pool){
        this.setPool(pool);
    }

    public SendMailPool getPool() {
        return pool;
    }

    public void setPool(SendMailPool pool) {
        this.pool = pool;
    }

    public void run() {
        pool.execute();
    }
}
