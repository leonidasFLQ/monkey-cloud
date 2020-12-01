package com.monkey4cloud.monkey.common.core.util;

import java.util.function.Supplier;

import com.monkey4cloud.monkey.common.core.constant.enums.CommonResponseEnum;
import com.monkey4cloud.monkey.common.core.pojo.response.CommonResult;
import com.monkey4cloud.monkey.common.core.pojo.response.PageDataResult;
import com.monkey4cloud.monkey.common.core.pojo.response.QueryData;

/**
 * <pre>
 *  远程调用工具类
 * </pre>
 *
 * @author sprainkle
 * @date 2019/5/2
 */
public class ClientUtil {

    /**
     * 封装远程调用, 只返回关心的内容
     * @param supplier 远程调用真正逻辑, 返回内容为: {@link R<T>}
     * @param <T> 关心的内容类型
     * @return 关心的内容
     */
    public static <T> T execute(Supplier<CommonResult<T>> supplier) {
        CommonResult<T> r = supplier.get();
        CommonResponseEnum.assertSuccess(r);
        return r.getData();
    }

    /**
     * 封装远程调用, 只返回关心的内容
     * @param supplier 程调用真正逻辑, 返回内容为: {@link QR<T>}
     * @param <T> 关心的内容类型
     * @return 关心的内容
     */
    public static <T> QueryData<T> executePage(Supplier<PageDataResult<T>> supplier) {
    	PageDataResult<T> qr = supplier.get();
        CommonResponseEnum.assertSuccess(qr);
        return qr.getData();
    }

}
