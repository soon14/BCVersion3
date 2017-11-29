package com.mrice.txl.appthree.bean;

import com.mrice.txl.appthree.http.ParamNames;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cai on 2017/8/19.
 */

public class PageInfo implements Serializable {

    /**
     * pageNum : 1
     * pageSize : 10
     * size : 3
     * startRow : 1
     * endRow : 3
     * total : 3
     * pages : 1
     * list : [{"id":15,"imgId":"81c08239-26ed-45f4-8c8f-ca2b9620dfa0","createUser":"[高手的姐]双色球092期红三胆连续4期中1枚","createDate":1496892207000,"updateUser":"2","updateDate":null,"flag":"1","sort":11,"url":"http://osef7u7wk.bkt.clouddn.com/81c08239-26ed-45f4-8c8f-ca2b9620dfa0","link":"http://osef7u7wk.bkt.clouddn.com/95728456-8a9e-440a-9204-1d40c97be91c.html","imgType":1,"appName":"测1试1"},{"id":31,"imgId":"6b281037-4e8d-435a-bec3-a3a7967831b2","createUser":"一周彩市数据:大乐透奖池首次突破40亿!","createDate":1496892207000,"updateUser":"2","updateDate":null,"flag":"1","sort":12,"url":"http://osef7u7wk.bkt.clouddn.com/6b281037-4e8d-435a-bec3-a3a7967831b2","link":"http://osef7u7wk.bkt.clouddn.com/cf3f879d-c713-440b-a60e-f069aaffe7b8.html","imgType":1,"appName":"测1试1"},{"id":32,"imgId":"9a6fdd5a-ecbb-42a2-9a08-a830ebc31da7","createUser":"彩民中2363万自信露脸领 却因大意差点错失大奖","createDate":1496892207000,"updateUser":"2","updateDate":null,"flag":"1","sort":13,"url":"http://osef7u7wk.bkt.clouddn.com/9a6fdd5a-ecbb-42a2-9a08-a830ebc31da7","link":"http://osef7u7wk.bkt.clouddn.com/a37abc01-b159-4f89-b7de-0e1b27ef54d9.html","imgType":1,"appName":"测1试1"}]
     * firstPage : 1
     * prePage : 0
     * nextPage : 0
     * lastPage : 1
     * isFirstPage : true
     * isLastPage : true
     * hasPreviousPage : false
     * hasNextPage : false
     * navigatePages : 8
     * navigatepageNums : [1]
     */
    @ParamNames("pageNum")
    private int pageNum;
    @ParamNames("pageSize")
    private int pageSize;
    @ParamNames("size")
    private int size;
    @ParamNames("startRow")
    private int startRow;
    @ParamNames("endRow")
    private int endRow;
    @ParamNames("total")
    private int total;
    @ParamNames("pages")
    private int pages;
    @ParamNames("firstPage")
    private int firstPage;
    @ParamNames("prePage")
    private int prePage;
    @ParamNames("nextPage")
    private int nextPage;
    @ParamNames("lastPage")
    private int lastPage;
    @ParamNames("isFirstPage")
    private boolean isFirstPage;
    @ParamNames("isLastPage")
    private boolean isLastPage;
    @ParamNames("hasPreviousPage")
    private boolean hasPreviousPage;
    @ParamNames("hasNextPage")
    private boolean hasNextPage;
    @ParamNames("navigatePages")
    private int navigatePages;
    @ParamNames("list")
    private List<BannerImageBean> list;
    @ParamNames("navigatepageNums")
    private List<Integer> navigatepageNums;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public List<BannerImageBean> getList() {
        return list;
    }

    public void setList(List<BannerImageBean> list) {
        this.list = list;
    }

    public List<Integer> getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(List<Integer> navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }
}
