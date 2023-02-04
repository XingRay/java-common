package com.xingray.java.base.page;

import java.util.List;

public class TimePage<T> {
    private int total;

    private long timestamp;

    private int pageSize;

    private List<T> dataList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
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
