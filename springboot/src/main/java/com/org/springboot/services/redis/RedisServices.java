package com.org.springboot.services.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by paopaobing on 2017/11/3.
 */
@Slf4j
@Service
public class RedisServices {

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    /**
     * 设置 redis缓存 String
     * @param key
     * @param val
     */
    public boolean setString(String key,String val){
        boolean saveFlag =false;
        log.info("设置redis缓存key：{}-val:{}",key,val);
        try {
            ShardedJedis shardJedis = shardedJedisPool.getResource();
            String result =shardJedis.set(key,val);
            log.info("redis存储结果：{}",result);
            shardJedis.close();
            if("OK".equals(result)){
                saveFlag =true;
            }
        }catch (Exception e){
            log.error("设置redis缓存异常：{}", e);
        }
        log.info("设置redis缓存结果：{}",saveFlag);
        return saveFlag;
    }

    public String getByKey(String key){
        ShardedJedis shardJedis = shardedJedisPool.getResource();
        String val  = shardJedis.get(key);
        shardJedis.close();
        return val;
    }

}
