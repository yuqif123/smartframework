package yu.smart4j.framework.helper;

import yu.smart4j.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yu on 2017/8/1.
 */
public final class BeanHelper {
    private static final Map<Class<?>,Object> BEAN_MAP =new HashMap<Class<?>,Object>();

    static {
        Set<Class<?>> classSet = ClassHelper.getClassSet();
        for (Class<?> cls : classSet) {
            BEAN_MAP.put(cls, ReflectionUtil.newInstance(cls));
        }
    }

    /**
     * 获取BeanMap
     */
    public static Map<Class<?>,Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取Bean实例
     */
    public static  <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get bean by class:" + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }
}
