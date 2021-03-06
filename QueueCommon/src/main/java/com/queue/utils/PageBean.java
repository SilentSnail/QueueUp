package com.queue.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.util.StringUtils;

import java.util.List;

/**
 * 分页工具类
 * Created by liusong on 2018/4/10.
 */
public class PageBean<T> {

    //总数据条数
    private long totalCount = 0;
    //查询页
    private int currentPage = 1;
    //总页数
    private long pageSize = 0;
    //每页数据条数
    private int dataSize = 10;
    //列表数据
    private List<T> list;

    public PageBean(){
        String pageNumStr = HttpContextUtils.getRequest().getParameter("page.pageNo");
        String dataSizeStr = HttpContextUtils.getRequest().getParameter("page.pageSize");
        if(StringUtils.hasLength(pageNumStr)){
            this.currentPage = Integer.parseInt(pageNumStr);
        }
        if(StringUtils.hasLength(dataSizeStr)){
            this.dataSize = Integer.parseInt(dataSizeStr);
        }
        PageHelper.startPage(this.currentPage, this.dataSize);
    }

    public void setData(List<T> data){
        this.list = data;
        if(data instanceof Page){
            this.pageSize = ((Page)this.list).getPages();
            this.totalCount = ((Page)this.list).getTotal();
        }
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
