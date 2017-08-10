package yu.smart4j.framework.bean;

import yu.smart4j.framework.util.CastUtil;
import yu.smart4j.framework.util.CollectionUtil;

import java.util.Map;

/**
 * 请求参数对象
 * Created by yu on 2017/8/3.
 */
public class Param {

    private Map<String ,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取long型参数值
     */
    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 获取所有字段信息
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }

    public boolean isEmpty() {
        return CollectionUtil.isEmpty(paramMap);
    }
}
