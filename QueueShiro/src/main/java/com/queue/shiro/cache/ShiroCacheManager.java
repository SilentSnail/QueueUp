package com.queue.shiro.cache;

import com.queue.shiro.bean.SpringCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * Created by liusong on 2018/4/26.
 */
public class ShiroCacheManager implements CacheManager {

    private Logger log = LogManager.getLogger(ShiroCacheManager.class);
    private org.springframework.cache.CacheManager cacheManager;

    public org.springframework.cache.CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public <K, V> Cache<K, V> getCache(String cacheName) throws CacheException {
        if(log.isTraceEnabled()){
            log.trace(cacheName);
        }
        org.springframework.cache.Cache cache = cacheManager.getCache(cacheName);
        return new SpringCache<K, V>(cache);
    }

    public void destory() throws Exception{

        cacheManager = null;
    }
}
