package yu.smart4j.framework.aspect;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yu.smart4j.framework.annotation.Controller;
import yu.smart4j.framework.proxy.Aspect;
import yu.smart4j.framework.proxy.AspectProxy;

import java.lang.reflect.Method;

/**
 * 拦截Controller的所有方法
 * Created by yu on 2017/8/5.
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug("---------------begin---------------");
        LOGGER.debug(String.format("class: %s", cls.getName()));
        LOGGER.debug(String.format("method: %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        LOGGER.debug(String.format("time: %dms", System.currentTimeMillis() - begin));
        LOGGER.debug("---------------end-----------------");
    }
}
