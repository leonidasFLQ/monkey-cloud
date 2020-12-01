package com.monkey4cloud.monkey.common.core.pojo.param;

import java.util.Collections;
import java.util.List;

import com.monkey4cloud.monkey.common.core.util.CollectionUtils;

public class Page<T> implements IPage<T> {

	private static final long serialVersionUID = 5900442739202685567L;

	/**
     * 鏌ヨ鏁版嵁鍒楄〃
     */
    private List<T> records = Collections.emptyList();
    /**
     * 鎬绘暟
     */
    private long total = 0;
    /**
     * 姣忛〉鏄剧ず鏉℃暟锛岄粯璁� 10
     */
    private long size = 10;
    /**
     * 褰撳墠椤�
     */
    private long current = 1;
    /**
     * SQL 鎺掑簭 ASC 鏁扮粍
     */
    private String[] ascs;
    /**
     * SQL 鎺掑簭 DESC 鏁扮粍
     */
    private String[] descs;
    /**
     * 鑷姩浼樺寲 COUNT SQL
     */
    private boolean optimizeCountSql = true;
    /**
     * 鏄惁杩涜 count 鏌ヨ
     */
    private boolean isSearchCount = true;

    public Page() {
        // to do nothing
    }

    /**
     * 鍒嗛〉鏋勯�犲嚱鏁�
     *
     * @param current 褰撳墠椤�
     * @param size    姣忛〉鏄剧ず鏉℃暟
     */
    public Page(long current, long size) {
        this(current, size, 0);
    }

    public Page(long current, long size, long total) {
        this(current, size, total, true);
    }

    public Page(long current, long size, boolean isSearchCount) {
        this(current, size, 0, isSearchCount);
    }

    public Page(long current, long size, long total, boolean isSearchCount) {
        if (current > 1) {
            this.current = current;
        }
        this.size = size;
        this.total = total;
        this.isSearchCount = isSearchCount;
    }

    /**
     * 鏄惁瀛樺湪涓婁竴椤�
     *
     * @return true / false
     */
    public boolean hasPrevious() {
        return this.current > 1;
    }

    /**
     * 鏄惁瀛樺湪涓嬩竴椤�
     *
     * @return true / false
     */
    public boolean hasNext() {
        return this.current < this.getPages();
    }

    @Override
    public List<T> getRecords() {
        return this.records;
    }

    @Override
    public Page<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public Page<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public Page<T> setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.current;
    }

    @Override
    public Page<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

    @Override
    public String[] ascs() {
        return ascs;
    }

    public Page<T> setAscs(List<String> ascs) {
        if (CollectionUtils.isNotEmpty(ascs)) {
            this.ascs = ascs.toArray(new String[0]);
        }
        return this;
    }


    /**
     * 鍗囧簭
     *
     * @param ascs 澶氫釜鍗囧簭瀛楁
     */
    public Page<T> setAsc(String... ascs) {
        this.ascs = ascs;
        return this;
    }

    @Override
    public String[] descs() {
        return descs;
    }

    public Page<T> setDescs(List<String> descs) {
        if (CollectionUtils.isNotEmpty(descs)) {
            this.descs = descs.toArray(new String[0]);
        }
        return this;
    }

    /**
     * 闄嶅簭
     *
     * @param descs 澶氫釜闄嶅簭瀛楁
     */
    public Page<T> setDesc(String... descs) {
        this.descs = descs;
        return this;
    }

    @Override
    public boolean optimizeCountSql() {
        return optimizeCountSql;
    }

    @Override
    public boolean isSearchCount() {
        if (total < 0) {
            return false;
        }
        return isSearchCount;
    }

    public Page<T> setSearchCount(boolean isSearchCount) {
        this.isSearchCount = isSearchCount;
        return this;
    }

    public Page<T> setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
        return this;
    }
}
