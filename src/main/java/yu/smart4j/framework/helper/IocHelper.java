package yu.smart4j.framework.helper;

import org.apache.commons.lang3.ArrayUtils;
import yu.smart4j.framework.annotation.Inject;
import yu.smart4j.framework.util.CollectionUtil;
import yu.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 * Created by yu on 2017/8/3.
 */
public final class IocHelper {
    static {
        //获取所有的Bean类与Bean实例之间的映射关系
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if (!CollectionUtil.isEmpty(beanMap)) {
            //遍历beanMap
            for(Map.Entry<Class<?>,Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取Bean类自定义的所有成员变量（Baan Field)
                Field[] beanFileds = beanClass.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(beanFileds)) {
                    //遍历beanField
                    for (Field beanField : beanFileds) {
                        //判断beanField是否带有Inject注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            //在beanMap中获得Bean Field对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                //通过反射初始化BeanField的值
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
