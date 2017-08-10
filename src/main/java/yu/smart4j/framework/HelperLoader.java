package yu.smart4j.framework;

import yu.smart4j.framework.helper.*;
import yu.smart4j.framework.util.ClassUtil;

/**
 * 加载相应的helper
 * Created by yu on 2017/8/3.
 */
public final class HelperLoader {

    public static  void init() {
        Class<?>[] classList = {
                ClassHelper.class,//封装class对象集合
                BeanHelper.class,//利用前面的class集合，封装bean实例对象集合
                AopHelper.class,//启动aop,原实例将被代理对象覆盖
                IocHelper.class,//检查前面bean实例是否包含Inject注解，如果有就为其赋值
                ControllerHelper.class//简历请求与controller的映射关系
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(),true);
        }
    }
}
