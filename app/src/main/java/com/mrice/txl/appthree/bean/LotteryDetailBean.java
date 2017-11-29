package com.mrice.txl.appthree.bean;

import com.mrice.txl.appthree.http.ParamNames;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cai on 2017/8/7.
 */

public class LotteryDetailBean implements Serializable {
    @ParamNames("code")
    private String code;
    @ParamNames("pageInfo")
    private PageInfo pageInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }


    public static class PageInfo implements Serializable {
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
        private List<LotteryDetailBeanIn> list;
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

        public boolean isFirstPage() {
            return isFirstPage;
        }

        public void setFirstPage(boolean firstPage) {
            isFirstPage = firstPage;
        }

        public boolean isLastPage() {
            return isLastPage;
        }

        public void setLastPage(boolean lastPage) {
            isLastPage = lastPage;
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

        public List<LotteryDetailBeanIn> getList() {
            return list;
        }

        public void setList(List<LotteryDetailBeanIn> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public class LotteryDetailBeanIn implements Serializable {
            @ParamNames("id")
            private Integer id;
            @ParamNames("no")
            private String no;
            @ParamNames("noDate")
            private Long noDate;
            @ParamNames("q1")
            private String q1;
            @ParamNames("q2")
            private String q2;
            @ParamNames("q3")
            private String q3;
            @ParamNames("q4")
            private String q4;
            @ParamNames("q5")
            private String q5;
            @ParamNames("q6")
            private String q6;
            @ParamNames("q7")
            private String q7;
            @ParamNames("type")
            private String type;

            public LotteryDetailBeanIn(Integer id, String no, Long noDate, String q1, String q2, String q3, String q4, String q5, String q6,
                                       String q7, String type) {
                super();
                this.id = id;
                this.no = no;
                this.noDate = noDate;
                this.q1 = q1;
                this.q2 = q2;
                this.q3 = q3;
                this.q4 = q4;
                this.q5 = q5;
                this.q6 = q6;
                this.q7 = q7;
                this.type = type;
            }


            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getNo() {
                return no;
            }

            public void setNo(String no) {
                this.no = no;
            }

            public Long getNoDate() {
                return noDate;
            }

            public void setNoDate(Long noDate) {
                this.noDate = noDate;
            }

            public String getQ1() {
                return q1 + getOneChar();
            }

            public void setQ1(String q1) {
                this.q1 = q1;
            }

            public String getQ2() {
                return q2 + getOneChar();
            }

            public String getOneChar() {
                return " ";
            }

            public void setQ2(String q2) {
                this.q2 = q2;
            }

            public String getQ3() {
                return q3 + getOneChar();
            }

            public void setQ3(String q3) {
                this.q3 = q3;
            }

            public String getQ4() {
                return q4 + getOneChar();
            }

            public void setQ4(String q4) {
                this.q4 = q4;
            }

            public String getQ5() {
                return q5 + getOneChar();
            }

            public void setQ5(String q5) {
                this.q5 = q5;
            }

            public String getQ6() {
                return q6 + getOneChar();
            }

            public void setQ6(String q6) {
                this.q6 = q6;
            }

            public String getQ7() {
                return q7 + getOneChar();
            }

            public void setQ7(String q7) {
                this.q7 = q7;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            @Override
            public String toString() {
                return "LotteryDetailBeanIn{" +
                        "id=" + id +
                        ", no='" + no + '\'' +
                        ", noDate=" + noDate +
                        ", q1='" + q1 + '\'' +
                        ", q2='" + q2 + '\'' +
                        ", q3='" + q3 + '\'' +
                        ", q4='" + q4 + '\'' +
                        ", q5='" + q5 + '\'' +
                        ", q6='" + q6 + '\'' +
                        ", q7='" + q7 + '\'' +
                        ", type='" + type + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "PageInfo{" +
                    "pageNum=" + pageNum +
                    ", pageSize=" + pageSize +
                    ", size=" + size +
                    ", startRow=" + startRow +
                    ", endRow=" + endRow +
                    ", total=" + total +
                    ", pages=" + pages +
                    ", firstPage=" + firstPage +
                    ", prePage=" + prePage +
                    ", nextPage=" + nextPage +
                    ", lastPage=" + lastPage +
                    ", isFirstPage=" + isFirstPage +
                    ", isLastPage=" + isLastPage +
                    ", hasPreviousPage=" + hasPreviousPage +
                    ", hasNextPage=" + hasNextPage +
                    ", navigatePages=" + navigatePages +
                    ", list=" + list +
                    ", navigatepageNums=" + navigatepageNums +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "NiceBean{" +
                "code='" + code + '\'' +
                ", pageInfo=" + pageInfo +
                '}';
    }

}
