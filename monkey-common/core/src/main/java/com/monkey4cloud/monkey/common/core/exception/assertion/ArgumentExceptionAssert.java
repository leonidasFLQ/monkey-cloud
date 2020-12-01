package com.monkey4cloud.monkey.common.core.exception.assertion;

import java.text.MessageFormat;

import com.monkey4cloud.monkey.common.core.constant.IResponseEnum;
import com.monkey4cloud.monkey.common.core.exception.ArgumentException;
import com.monkey4cloud.monkey.common.core.exception.BaseException;

/**
 * <pre>
 *
 * </pre>
 *
 * @author sprainkle
 * @date 2019/5/2
 */
public interface ArgumentExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new ArgumentException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new ArgumentException(this, args, msg, t);
    }

}
