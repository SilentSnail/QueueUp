package com.queue.mail.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.concurrent.*;

/**
 * Created by liusong on 2018/6/9.
 */
public class SendMailPool implements Runnable {

    private Logger log = LogManager.getLogger(this.getClass());
//    Executors.newCachedThreadPool();//创建预定义可缓存线程池
//    Executors.newFixedThreadPool(100);//创建预定义定长线程池
//    Executors.newScheduledThreadPool(100);//创建预定义定长线程池,支持定时以及周期性任务执行
//    Executors.newSingleThreadExecutor();//创建一个单线程化线程池，用唯一的线程来执行任务，保证任务按指定顺序执行
    private ThreadPoolExecutor pool;//执行线程池
    private static int poolSize = 3;//最小线程数
    private static int maxPoolSize = 5;//最大线程数
    private static Long keepLiveTime = 30000L;//线程没有任务执行时最多保持多久时间会终止
    private static TimeUnit unit = TimeUnit.MILLISECONDS;//keepLiveTime的时间单位
    private LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();//阻塞队列
    private Integer status = -1;

    public void execute() {
        log.debug("发送邮件线程池启动了");
        if(pool == null){
            throw new NullPointerException("mail线程池尚未初始化");
        }
        Runnable thread;
        while (true){
            try {
                thread = this.getRunnable();
                if(thread == null){//如果没有任务 则休息10秒
                    synchronized (this){
                        try {
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
                        log.debug("发送邮件线程已经开始执行");
                    }
                    //此处应该还有满了如何处理，暂时先不考虑
                }
            } catch (Exception e) {
                log.error(e.getMessage());
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
            pool = new ThreadPoolExecutor(poolSize, maxPoolSize, keepLiveTime, unit, queue);//自定义线程池
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