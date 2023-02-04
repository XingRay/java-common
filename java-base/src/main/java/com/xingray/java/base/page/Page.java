package com.xingray.java.base.page;

import java.util.List;

public class Page<T> {
    private long total;

    private long pageIndex;

    private long pageSize;

    private List<T> dataList;

    public Page() {
    }

    public Page(int total, int pageIndex, int pageSize, List<T> dataList) {
        this.total = total;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.dataList = dataList;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
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
        return "Page{" +
                "total=" + total +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", dataList=" + dataList +
                '}';
    }
}
