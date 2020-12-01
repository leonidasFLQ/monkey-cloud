package com.monkey4cloud.monkey.common.core.util;

import java.util.Collection;
import java.util.Map;

public class CollectionUtils {
	
	/**
     * 鏍￠獙闆嗗悎鏄惁涓虹┖
     *
     * @param coll 鍏ュ弬
     * @return boolean
     */
    public static boolean isEmpty(Collection<?> coll) {
        return (coll == null || coll.isEmpty());
    }

    /**
     * 鏍￠獙闆嗗悎鏄惁涓嶄负绌�
     *
     * @param coll 鍏ュ弬
     * @return boolean
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * 鍒ゆ柇Map鏄惁涓虹┖
     *
     * @param map 鍏ュ弬
     * @return boolean
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    /**
     * 鍒ゆ柇Map鏄惁涓嶄负绌�
     *
     * @param map 鍏ュ弬
     * @return boolean
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
	
}
