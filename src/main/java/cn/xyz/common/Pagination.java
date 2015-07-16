package cn.xyz.common;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 这是一个分页工具类，用于向上层说明关于分页的信息
 * 包括分页的总记录数，分页的大小，总页数以及当前页
 * 当然，还包括最重要的页的内容，在list集合中存放
 * 
 * 
 * @author luojie 2014年10月22日 下午8:39:44
 */
public class Pagination<T> implements Serializable{

	private static final long serialVersionUID = 2L;
    private static final int  DEFAULT_PAGE_SIZE = 10;

    private int               totalCount;
    private int               pageNo;   //the number of current page
    private int               pageSize;
    private int               totalPage;

    private List<T>           list;

    public Pagination() {
    }

    public Pagination(int offset, int limit, int totalCount, List<T> list) {
        if (limit <= 0) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        } else {
            this.pageSize = limit;
        }

        if (offset <= 0) {
            this.pageNo = 1;
        } else {
            this.pageNo = offset / this.pageSize + 1;
        }

        if (totalCount < 0) {
            this.totalCount = 0;
        } else {
            this.totalCount = totalCount;
        }
       
        totalPage = (this.totalCount % this.pageSize == 0) ? this.totalCount / this.pageSize : this.totalCount
                / this.pageSize + 1;

        this.list = list;

    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }


    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);
    }

}

