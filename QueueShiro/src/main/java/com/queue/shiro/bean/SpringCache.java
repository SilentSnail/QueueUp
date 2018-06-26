package com.queue.shiro.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.cache.CacheException;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Created by liusong on 2018/4/26.
 */
public class SpringCache<K, V> implements org.apache.shiro.cache.Cache<K, V> {

    private Logger log = LogManager.getLogger(SpringCache.class);

    private Cache cache;

    public SpringCache(Cache cache){
        if(cache == null){
            throw new NullPointerException("Cache is null");
        }
        this.cache = cache;
    }

    public V get(K key) throws CacheException {
        ValueWrapper value =  cache.get(key);
        if(value == null){
            if(log.isTraceEnabled()){
                log.trace(this.cache.getName() + "value is null");
            }
            return null;
        }
        return (V) value.get();
    }

    public V put(K key, V value) throws CacheException {
        V worth = get(key);
        cache.put(key, value);
        return worth;
    }

    public V remove(K key) throws CacheException {
        V worth = get(key);
        cache.evict(key);
        return worth;
    }

    public void clear() throws CacheException {
        cache.clear();
    }

    public int size() {
        return 0;
    }

    public Set<K> keys() {//返回一个不能添加元素的空集
        return Collections.emptySet();
    }

    public Collection<V> values() {
        return Collections.emptySet();
    }

    public String toString(){
        return "SpringCache ["+this.cache.getName()+"]";
    }
}
