package com.queue.mail.send;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liusong on 2018/6/9.
 */
public class SendMailPool implements Runnable {

    private ThreadPoolExecutor pool;//执行线程池
    private static int poolSize = 3;//线程池大小
    private static int maxPoolSize = 5;//线程池最大大小
    private static Long keepLiveTime = 30000L;//线程没有任务执行时最多保持多久时间会终止
    private static TimeUnit unit = TimeUnit.MILLISECONDS;//keepLiveTime的时间单位
    private LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();//阻塞队列
    private Integer status = -1;

    public void execute() {
        System.out.println("mail线程池开始执行");
        if(pool == null){
            throw new NullPointerException("mail线程池尚未初始化");
        }
        Runnable thread;
        while (true){
            thread = this.getRunnable();
            if(thread == null){//如果没有任务 则休息10秒
                synchronized (this){
                    try {
                        System.out.println("线程池进行休眠");
                        this.setStatus(0);
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                continue;
            }
            if(thread instanceof SendMail){
                //如果等待的阻塞队列没有满，或者当前执行的队列小于线程池的最大值
                if(pool.getQueue().size() < 20 || pool.getPoolSize() < pool.getMaximumPoolSize()){
                    pool.execute(thread);//加入到执行的阻塞列表或者执行列表
                    this.queue.remove(thread);
                }
            }
        }
    }

    /**
     * 添加邮件发送任务
     */
    public synchronized void setRunnable(Runnable thread){
        this.queue.add(thread);
        if(this.getStatus() == 0){
            this.notify();
            this.setStatus(1);
        }
    }

    /**
     * 获取线程池中的任务
     * @return
     */
    private Runnable getRunnable(){
        Iterator<Runnable> iter = queue.iterator();
        while (iter.hasNext()){
            return iter.next();
        }
        return null;
    }

    /**
     * LinkedBlockingQueue的介绍：https://blog.csdn.net/javazejian/article/details/77410889
     * LinkedBlockingQueue的take方法作用
     * 获取并移除队列的头部。如果没有元素，则进入阻塞状态。
     * @return
     * @throws InterruptedException
     */
    public Runnable getThread() throws InterruptedException {
        return this.queue.take();
    }

    /**
     * LinkedBlockingQueue的put方法作用
     * 将指定元素thread追加到队列的尾部。如果队列已满，则进入阻塞状态
     * @param thread
     * @throws InterruptedException
     */
    public void putThread(Runnable thread) throws InterruptedException {
        this.queue.put(thread);
    }

    public int getRunnableSize(){
        return this.queue.size();
    }

    public SendMailPool(){
        this(poolSize, maxPoolSize, keepLiveTime);
    }

    public SendMailPool(int poolSize, int maxPoolSize, Long keepLiveTime){
        this(poolSize, maxPoolSize, keepLiveTime, unit);
    }

    public SendMailPool(int poolSize, int maxPoolSize, Long keepLiveTime, TimeUnit unit){
        if(pool == null) {
            pool = new ThreadPoolExecutor(poolSize, maxPoolSize, keepLiveTime, unit, queue);
        }
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

    public synchronized void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void run() {
        this.execute();
    }
}