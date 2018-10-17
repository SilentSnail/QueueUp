package com.queue.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by liusong on 2018/10/10.
 */
@Service
public class RedisUtils<K, V> {

    private RedisTemplate<K, V> redisTemplate;
    private static final Long TIME_OUT = 3600L;
    private static final TimeUnit TIME_UNIT_DEFAULT = TimeUnit.SECONDS;

    public void setValue(K key, V value){
        this.setValue(key, value, TIME_OUT, TIME_UNIT_DEFAULT);
    }

    public void setValue(K key, V value, TimeUnit timeUnit){
        this.setValue(key, value, TIME_OUT, timeUnit);
    }

    public void setValue(K key, V value, Long timeOut){
        this.setValue(key, value, timeOut, TIME_UNIT_DEFAULT);
    }

    public void setValue(K key, V value, Long timeOut, TimeUnit time){
        this.redisTemplate.opsForValue().set(key, value, timeOut, time);
    }

    public V get(K key){
        return this.redisTemplate.opsForValue().get(key);
    }

    public void setMap(K key, Map<String, Object> value){
        this.redisTemplate.opsForHash().putAll(key, value);
    }

    public Map<Object, Object> getMap(K key){
        return this.redisTemplate.opsForHash().entries(key);
    }

    public void remove(K key){
        this.redisTemplate.delete(key);
    }

    public void dels(K ... keys){
        if(keys != null && keys.length > 0) {
            if (keys.length == 1) {
                this.remove(keys[0]);
            } else {
                this.redisTemplate.delete(CollectionUtils.arrayToList(keys));
            }
        }
    }
}