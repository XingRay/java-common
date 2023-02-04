package com.xingray.java.base.page;

import java.util.List;

public class TimePage<T> {
    private long total;

    private long timestamp;

    private long pageSize;

    private List<T> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "TimePage{" +
                "total=" + total +
                ", timestamp=" + timestamp +
                ", pageSize=" + pageSize +
                ", dataList=" + dataList +
                '}';
    }
}
