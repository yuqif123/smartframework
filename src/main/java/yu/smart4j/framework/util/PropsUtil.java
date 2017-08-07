package yu.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by yu on 2017/7/28.
 * 属性文件工具类
 */
public final class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     */
    public static Properties loadProps(String fileName) {
        Properties props = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is == null) {
                //注意这里的用法，throw后下面的catch马上捕捉了，否则该方法外需要throws该异常
                throw new FileNotFoundException();
            }
            props = new Properties();
            props.load(is);
        } catch (IOException e) {
            LOGGER.error("load properties file error",e);
        } finally {
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("Stream close error",e);
                }
            }
        }
        return props;
    }

    /**
     * 获取字符型属性（默认值为空字符串）
     */
    public static String getString(Properties props,String key) {
        return getString(props,key,"");
    }

    /**
     * 获取默认字符型属性（可指定默认值）
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if(props.containsKey(key)) {
            value = props.getProperty(key);
        }
        return value;
    }

    /**
     * 获取数值型属性（默认值为0）
     */
    public static int getInt(Properties props,String key) {
        return getInt(props,key,0);
    }

    public static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if(props.containsKey(key)) {
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }

    public static boolean getBoolean(Properties props,String key) {
        return getBoolean(props,key,false);
    }

    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if(props.contains(key)) {
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;

    }
}
