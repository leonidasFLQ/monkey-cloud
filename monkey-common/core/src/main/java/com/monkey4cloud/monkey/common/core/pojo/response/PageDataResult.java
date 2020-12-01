package com.monkey4cloud.monkey.common.core.pojo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页数据通用返回对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PageDataResult<T> extends CommonResult<QueryData<T>> {
    
	public PageDataResult() {
    }

    public PageDataResult(QueryData<T> data) {
        super(data);
    }
    
}
