package yu.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by yu on 2017/7/28.
 */
public final class CastUtil {

    public static String castString(Object obj) {
        return castString(obj,"");
    }

    private static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static int castInt(Object obj) {
        return CastUtil.castInt(obj,0);
    }

    public static int castInt(Object obj, int defaultValue) {
        int intValue = defaultValue;
        if(obj != null) {
            String strValue = castString(obj);
            if(StringUtils.isNoneEmpty(strValue)) {
                try {
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }

    public static boolean castBoolean(Object obj) {
        return castBoolean(obj,false);
    }

    public static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if(obj != null) {
            booleanValue = Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }


    public static long castLong(Object o) {
        return castLong(o,0L);
    }

    private static long castLong(Object o, long defaultValue) {
        long value = defaultValue;
        try {
            value = Long.valueOf(castString(o));
            if (o != null) {
                String strVal = castString(o);
                if (StringUtils.isNotEmpty(strVal)) {
                    value = Long.valueOf(strVal);
                }
            }
        } catch (NumberFormatException e) {
            value = defaultValue;
        }
        return value;
    }
}
