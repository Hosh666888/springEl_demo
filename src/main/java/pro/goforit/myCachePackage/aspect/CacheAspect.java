package pro.goforit.myCachePackage.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import pro.goforit.myCachePackage.Util.ElUtil;
import pro.goforit.myCachePackage.Util.PersistUtil;
import pro.goforit.myCachePackage.anno.Cache;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/24 8:33
 * @desc:
 **/
@Aspect
@Component
public class CacheAspect {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;


    @Around("@annotation(cache)")
    public Object around(ProceedingJoinPoint joinPoint, Cache cache) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();
        String key =  cache.key();
        String s = ElUtil.parseKey(method, args, key);
        System.out.println("生成key--->"+s);

        Object cacheValue = PersistUtil.get(redisTemplate, s);
        if (cacheValue==null) {
            Object proceed = joinPoint.proceed(args);
            PersistUtil.save(redisTemplate,s,proceed,cache.expireIn(),cache.timeUnit(),cache.randomness(),cache.randomnessTimeUnit());
            return proceed;
        }

        return cacheValue;

    }



}
