package yu.smart4j.framework.util;

import org.apache.commons.collections4.MapUtils;

import java.util.Map;

/**
 * Created by yu on 2017/7/31.
 */
public final class CollectionUtil {

    /**
     * 判断map是否为空
     */
    public static boolean isEmpty(Map<?,?> map) {
        return MapUtils.isEmpty(map);
    }

}
