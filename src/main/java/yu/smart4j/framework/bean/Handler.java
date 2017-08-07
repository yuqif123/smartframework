package yu.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * 封装Action信息
 * Created by yu on 2017/8/3.
 */
public class Handler {

    /**
     * Controller
     */
    private Class<?> controllerClass;

    /**
     * Action方法
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
