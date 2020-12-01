package com.monkey4cloud.monkey.common.core.pojo.param;

import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface IPage<T> extends Serializable {
	
	 /**
     * 闄嶅簭瀛楁鏁扮粍
     *
     * @return order by desc 鐨勫瓧娈垫暟缁�
     */
    default String[] descs() {
        return null;
    }

    /**
     * 鍗囧簭瀛楁鏁扮粍
     *
     * @return order by asc 鐨勫瓧娈垫暟缁�
     */
    default String[] ascs() {
        return null;
    }

    /**
     * KEY/VALUE 鏉′欢
     *
     * @return ignore
     */
    default Map<Object, Object> condition() {
        return null;
    }

    /**
     * 鑷姩浼樺寲 COUNT SQL銆� 榛樿锛歵rue 銆�
     *
     * @return true 鏄� / false 鍚�
     */
    default boolean optimizeCountSql() {
        return true;
    }

    /**
     * 杩涜 count 鏌ヨ 銆� 榛樿: true 銆�
     *
     * @return true 鏄� / false 鍚�
     */
    default boolean isSearchCount() {
        return true;
    }

    /**
     * 璁＄畻褰撳墠鍒嗛〉鍋忕Щ閲�
     */
    default long offset() {
        return getCurrent() > 0 ? (getCurrent() - 1) * getSize() : 0;
    }

    /**
     * 褰撳墠鍒嗛〉鎬婚〉鏁�
     */
    default long getPages() {
        if (getSize() == 0) {
            return 0L;
        }
        long pages = getTotal() / getSize();
        if (getTotal() % getSize() != 0) {
            pages++;
        }
        return pages;
    }

    /**
     * 鍐呴儴浠�涔堜篃涓嶅共
     * <p>鍙槸涓轰簡 json 鍙嶅簭鍒楀寲鏃朵笉鎶ラ敊</p>
     */
    default IPage<T> setPages(long pages) {
        // to do nothing
        return this;
    }

    /**
     * 鍒嗛〉璁板綍鍒楄〃
     *
     * @return 鍒嗛〉瀵硅薄璁板綍鍒楄〃
     */
    List<T> getRecords();

    /**
     * 璁剧疆鍒嗛〉璁板綍鍒楄〃
     */
    IPage<T> setRecords(List<T> records);

    /**
     * 褰撳墠婊¤冻鏉′欢鎬昏鏁�
     *
     * @return 鎬绘潯鏁�
     */
    long getTotal();

    /**
     * 璁剧疆褰撳墠婊¤冻鏉′欢鎬昏鏁�
     */
    IPage<T> setTotal(long total);

    /**
     * 褰撳墠鍒嗛〉鎬婚〉鏁�
     *
     * @return 鎬婚〉鏁�
     */
    long getSize();

    /**
     * 璁剧疆褰撳墠鍒嗛〉鎬婚〉鏁�
     */
    IPage<T> setSize(long size);

    /**
     * 褰撳墠椤碉紝榛樿 1
     *
     * @return 褰撶劧椤�
     */
    long getCurrent();

    /**
     * 璁剧疆褰撳墠椤�
     */
    IPage<T> setCurrent(long current);

    /**
     * IPage 鐨勬硾鍨嬭浆鎹�
     *
     * @param mapper 杞崲鍑芥暟
     * @param <R>    杞崲鍚庣殑娉涘瀷
     * @return 杞崲娉涘瀷鍚庣殑 IPage
     */
    @SuppressWarnings("unchecked")
    default <R> IPage<R> convert(Function<? super T, ? extends R> mapper) {
        List<R> collect = this.getRecords().stream().map(mapper).collect(toList());
        return ((IPage<R>) this).setRecords(collect);
    }
}
