package pro.goforit.myCachePackage.anno;

import java.lang.annotation.*;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/11/14 15:16
 * @desc:
 **/
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface CacheDelete {

    /**
     *  使用正则
     * @return
     */
    boolean useRegex() default false;


    String key();

}
