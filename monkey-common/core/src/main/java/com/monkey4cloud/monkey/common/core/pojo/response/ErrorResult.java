package com.monkey4cloud.monkey.common.core.pojo.response;

/**
 * 错误返回对象
 */
public class ErrorResult extends BaseResult {

    public ErrorResult() {
    }

    public ErrorResult(long code, String message) {
        super(code, message);
    }
}
