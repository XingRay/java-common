package com.xingray.java.util;

public class PageUtil {

    public static int getLimitStart(int pageIndex, int pageSize) {
        return (pageIndex - 1) * pageSize;
    }

    public static long getPageCount(long totalCount, int pageSize) {
        return totalCount % pageSize == 0
                ? totalCount / pageSize
                : ((totalCount / pageSize) + 1);
    }
}
