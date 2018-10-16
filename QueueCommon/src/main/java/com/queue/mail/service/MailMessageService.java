package com.queue.mail.service;

import com.queue.mail.entity.MailMessage;
import com.queue.mail.util.SendMail;
import com.queue.mail.util.SendMailPool;

import java.util.concurrent.TimeUnit;

/**
 * Created by liusong on 2018/7/10.
 */
public class MailMessageService {

    private static SendMailPool pool;

    private int poolSize = 3;//线程池大小
    private int maxPoolSize = 5;//线程池最大大小
    private Long keepLiveTime = 30000L;//线程没有任务执行时最多保持多久时间会终止
    private TimeUnit unit = TimeUnit.MILLISECONDS;//keepLiveTime的时间单位

    public void init() {
        new Thread(this.getInstance()).start();
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public Long getKeepLiveTime() {
        return keepLiveTime;
    }

    public void setKeepLiveTime(Long keepLiveTime) {
        this.keepLiveTime = keepLiveTime;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    private SendMailPool getInstance(){
        if(pool != null){
            return pool;
        }
        synchronized (this) {
            if (pool == null) {
                pool = new SendMailPool(this.getPoolSize(), this.getMaxPoolSize(), this.getKeepLiveTime(), this.getUnit());
            }
        }
        return pool;
    }

    public SendMailPool getMailPool(){
        return pool;
    }

    public void sendMail(MailMessage mail){
        this.pool.setRunnable(new SendMail(mail));
    }
}
