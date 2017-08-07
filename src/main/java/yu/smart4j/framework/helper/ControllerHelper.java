package yu.smart4j.framework.helper;

import org.apache.commons.lang3.ArrayUtils;
import yu.smart4j.framework.annotation.Action;
import yu.smart4j.framework.bean.Handler;
import yu.smart4j.framework.bean.Request;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器助手类
 * Created by yu on 2017/8/3.
 */
public final class ControllerHelper {

    /**
     * 用于存放请求与处理器的映射关系 （简称ActionMap)
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        //获取所有Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if(!controllerClassSet.isEmpty()) {
            //遍历这些controller类
            for(Class<?> controllerClass : controllerClassSet) {
                //获取所有Method
                Method[] methods = controllerClass.getDeclaredMethods();
                if(ArrayUtils.isNotEmpty(methods)) {
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Action.class)) {
                            Action action = method.getDeclaredAnnotation(Action.class);
                            String mapping = action.value();
                            //验证URL映射规则
                            if(mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtils.isNotEmpty(array) && array.length == 2) {
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    //初始化ActionMap
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
             }
        }
    }

    /**
     * 获取Handler
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
