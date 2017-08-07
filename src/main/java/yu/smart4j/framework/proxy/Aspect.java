package yu.smart4j.framework.proxy;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by yu on 2017/8/5.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 注解
     */
    Class<? extends Annotation> value();


}
