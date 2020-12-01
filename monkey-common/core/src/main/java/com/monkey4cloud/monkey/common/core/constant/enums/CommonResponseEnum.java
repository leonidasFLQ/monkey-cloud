package com.monkey4cloud.monkey.common.core.constant.enums;

import com.monkey4cloud.monkey.common.core.exception.BaseException;
import com.monkey4cloud.monkey.common.core.exception.assertion.CommonExceptionAssert;
import com.monkey4cloud.monkey.common.core.pojo.response.BaseResult;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>通用返回结果</p>
 *
 * @author sprainkle
 * @date 2019/5/2
 */
@Getter
@AllArgsConstructor
public enum CommonResponseEnum implements CommonExceptionAssert {
    
	SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    SERVER_BUSY(9998, "服务器繁忙"),
    SERVER_ERROR(9999, "系统或网络异常"),

    ;

    /**
     * 返回码
     */
    private long code;
    /**
     * 返回消息
     */
    private String message;

    /**
     * 校验返回结果是否成功
     * @param response 远程调用的响应
     */
    public static void assertSuccess(BaseResult response) {
        SERVER_ERROR.assertNotNull(response);
        long code = response.getCode();
        if (CommonResponseEnum.SUCCESS.getCode() != code) {
            String msg = response.getMessage();
            throw new BaseException(code, msg);
        }
    }
}
