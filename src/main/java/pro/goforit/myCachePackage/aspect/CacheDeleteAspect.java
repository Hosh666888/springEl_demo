package pro.goforit.myCachePackage.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import pro.goforit.myCachePackage.Util.PersistUtil;
import pro.goforit.myCachePackage.anno.CacheDelete;

import javax.annotation.Resource;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/11/14 15:41
 * @desc:
 **/
@Component
@Aspect
public class CacheDeleteAspect {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @AfterReturning(value = "@annotation(cacheDelete)")
    public void afterReturning(CacheDelete cacheDelete){
        PersistUtil.delete(redisTemplate, cacheDelete.key(),cacheDelete.useRegex());
    }

}
