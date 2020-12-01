package com.monkey4cloud.monkey.common.core.pojo.response;

import com.monkey4cloud.monkey.common.core.constant.IResponseEnum;
import com.monkey4cloud.monkey.common.core.constant.enums.CommonResponseEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通用返回对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CommonResult<T> extends BaseResult {
    /**
     * 数据列表
     */
    protected T data;

    public CommonResult() {
        super();
    }

    protected CommonResult(T data) {
        super();
        this.data = data;
    }
    
    protected CommonResult(T data, String message) {
    	super();
        this.data = data;
        this.message = message;
    }
    
    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(CommonResponseEnum.SUCCESS.getCode(), CommonResponseEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(CommonResponseEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> CommonResult<T> failed(IResponseEnum errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> CommonResult<T> failed(IResponseEnum errorCode,String message) {
        return new CommonResult<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(CommonResponseEnum.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed() {
        return failed(CommonResponseEnum.FAILED);
    }
    
    /**
     * 异常结果返回
     * @param e
     */
    public CommonResult(Throwable e) {
    	super();
        this.message = e.getMessage();
        this.code = -10000;
    }
}
