package com.monkey4cloud.monkey.common.core.pojo.response;

import com.monkey4cloud.monkey.common.core.constant.IResponseEnum;
import com.monkey4cloud.monkey.common.core.constant.enums.CommonResponseEnum;

import lombok.Data;

/**
 * <p>基础返回结果</p>
 *
 * @author sprainkle
 * @date 2019/5/2
 */
@Data
public class BaseResult {
    /**
     * 返回码
     */
    protected long code;
    /**
     * 返回消息
     */
    protected String message;

    public BaseResult() {
        // 默认创建成功的回应
        this(CommonResponseEnum.SUCCESS);
    }

    public BaseResult(IResponseEnum responseEnum) {
        this(responseEnum.getCode(), responseEnum.getMessage());
    }

    public BaseResult(long code, String message) {
        this.code = code;
        this.message = message;
    }

}
