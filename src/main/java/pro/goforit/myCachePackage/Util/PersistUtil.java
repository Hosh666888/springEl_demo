package pro.goforit.myCachePackage.Util;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/11/14 15:20
 * @desc:
 **/
public class PersistUtil {

    public static <T> void save(RedisTemplate<String,Object> redisTemplate, String key, T value, long expireIn, TimeUnit timeUnit, long randomness, TimeUnit randomnessTimeunit){
        long l = timeUnit.toMillis(expireIn) + (long) Math.ceil(Math.random() * randomnessTimeunit.toMillis(randomness));
        redisTemplate.opsForValue().set(key,value,l,TimeUnit.MILLISECONDS);
    }


    public static Object get(RedisTemplate<String,Object> redisTemplate,String key){
        if (!redisTemplate.hasKey(key)) {
            return null;
        }
        return redisTemplate.opsForValue().get(key);
    }

    public static boolean delete(RedisTemplate<String,Object> redisTemplate,String key,boolean useRegex){
        return redisTemplate.delete(key);
    }




}
