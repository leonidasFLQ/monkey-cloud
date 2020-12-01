package com.monkey4cloud.monkey.common.core.exception.assertion;

import java.text.MessageFormat;

import com.monkey4cloud.monkey.common.core.constant.IResponseEnum;
import com.monkey4cloud.monkey.common.core.exception.BaseException;
import com.monkey4cloud.monkey.common.core.exception.BusinessException;

/**
 * <p>业务异常断言</p>
 *
 * @author sprainkle
 * @date 2019/5/2
 */
public interface BusinessExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        
        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        
        return new BusinessException(this, args, msg, t);
    }

}
