package pro.goforit.myCachePackage.anno;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/24 8:33
 * @desc:
 **/
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface Cache {

    String key();

    /**
     *      过期时间
     * @return
     */
    long expireIn() default 1;

    /**
     *   过期时间单位
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.HOURS;

    /**
     *  随机附加时间范围
     * @return
     */
    int randomness() default 10;

    /**
     *  随即附加时间范围单位
     * @return
     */
    TimeUnit randomnessTimeUnit() default TimeUnit.SECONDS;


}
