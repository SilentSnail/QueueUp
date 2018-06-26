package com.queue.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liusong on 2018/4/10.
 */
public class PageUtils implements Serializable {

    //总数据条数
    private long totalCount;
    //当前页
    private int currentPage;
    //总页数
    private long pageSize;
    //每页数据条数
    private int dataSize;
    //列表数据
    private List<?> list;

    public PageUtils(){
        String pageNumStr = HttpContextUtils.getRequest().getParameter("page.pageNum");
        String dataSizeStr = HttpContextUtils.getRequest().getParameter("page.pageSize");
        if(StringUtil.isEmpty(pageNumStr)){
            this.currentPage = Integer.parseInt(pageNumStr);
        }
        if(StringUtil.isEmpty(dataSizeStr)){
            this.dataSize = Integer.parseInt(dataSizeStr);
        }
        PageHelper.startPage(this.currentPage, this.dataSize);
    }

    public void setData(List<?> data){
        this.list = data;
        if(data instanceof Page){
            this.pageSize = ((Page)this.list).getPages();
            this.totalCount = ((Page)this.list).getTotal();
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getDataSize() {
        return dataSize;
    }

    public long getPageSize() {
        return pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }
}
