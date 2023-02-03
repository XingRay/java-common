package com.xingray.java.base.page;

import java.util.List;

public class Page<T> {
    private int total;

    private int pageIndex;

    private int pageSize;

    private List<T> dataList;

    public Page() {
    }

    public Page(int total, int pageIndex, int pageSize, List<T> dataList) {
        this.total = total;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.dataList = dataList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
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
        return "Page{" +
                "total=" + total +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", dataList=" + dataList +
                '}';
    }
}
