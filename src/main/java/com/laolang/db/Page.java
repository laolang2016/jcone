package com.laolang.db;
 
/**
 * 分页信息类，用于封装分页的所有信息
 * 
 * @author 小代码
 * @version 1.0
 */
public class Page {
 
    /**
     * 创建一个分页信息类
     *
     * @param everyPage
     *            每页显示记录数
     * @param totalCount
     *            总记录数
     * @param totalPage
     *            总页数
     * @param currentPage
     *            当前页
     * @param beginIndex
     *            查询起始点
     * @param hasPrePage
     *            是否有上一页
     * @param hasNextPage
     *            是否有下一页
     */
    public Page(int everyPage, int totalCount, int totalPage, int currentPage,
            int beginIndex, boolean hasPrePage, boolean hasNextPage) { // 自定义构造方法
        this.everyPage = everyPage;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.beginIndex = beginIndex;
        this.hasPrePage = hasPrePage;
        this.hasNextPage = hasNextPage;
    }
 
    @Override
    public String toString() {
        return "Page [everyPage=" + everyPage + ", totalCount=" + totalCount
                + ", totalPage=" + totalPage + ", currentPage=" + currentPage
                + ", beginIndex=" + beginIndex + ", hasPrePage=" + hasPrePage
                + ", hasNextPage=" + hasNextPage + "]";
    }
 
    /**
     * Instantiates a new page.
     */
    public Page() {
    } // 默认构造函数
 
    /**
     * Gets the every page.
     *
     * @return the every page
     */
    public int getEveryPage() { // 获得每页显示记录数
        return everyPage;
    }
 
    /**
     * Sets the every page.
     *
     * @param everyPage
     *            the new every page
     */
    public void setEveryPage(int everyPage) {// 设置每页显示记录数
        this.everyPage = everyPage;
    }
 
    /**
     * Gets the total count.
     *
     * @return the total count
     */
    public int getTotalCount() {// 获得总记录数
        return totalCount;
    }
 
    /**
     * Sets the total count.
     *
     * @param totalCount
     *            the new total count
     */
    public void setTotalCount(int totalCount) {// 设置总记录数
        this.totalCount = totalCount;
    }
 
    /**
     * Gets the total page.
     *
     * @return the total page
     */
    public int getTotalPage() {// 获得总页数
        return totalPage;
    }
 
    /**
     * Sets the total page.
     *
     * @param totalPage
     *            the new total page
     */
    public void setTotalPage(int totalPage) {// 设置总页数
        this.totalPage = totalPage;
    }
 
    /**
     * Gets the current page.
     *
     * @return the current page
     */
    public int getCurrentPage() {// 获得当前页
        return currentPage;
    }
 
    /**
     * Sets the current page.
     *
     * @param currentPage
     *            the new current page
     */
    public void setCurrentPage(int currentPage) {// 设置当前页
        this.currentPage = currentPage;
    }
 
    /**
     * Gets the begin index.
     *
     * @return the begin index
     */
    public int getBeginIndex() {// 获得查询起始点
        return beginIndex;
    }
 
    /**
     * Sets the begin index.
     *
     * @param beginIndex
     *            the new begin index
     */
    public void setBeginIndex(int beginIndex) {// 设置查询起始点
        this.beginIndex = beginIndex;
    }
 
    /**
     * Checks if is checks for pre page.
     *
     * @return true, if is checks for pre page
     */
    public boolean isHasPrePage() {// 获得是否有上一页
        return hasPrePage;
    }
 
    /**
     * Sets the checks for pre page.
     *
     * @param hasPrePage
     *            the new checks for pre page
     */
    public void setHasPrePage(boolean hasPrePage) {// 设置是否有上一页
        this.hasPrePage = hasPrePage;
    }
 
    /**
     * Checks if is checks for next page.
     *
     * @return true, if is checks for next page
     */
    public boolean isHasNextPage() {// 获得是否有下一页
        return hasNextPage;
    }
 
    /**
     * Sets the checks for next page.
     *
     * @param hasNextPage
     *            the new checks for next page
     */
    public void setHasNextPage(boolean hasNextPage) {// 设置是否有下一页
        this.hasNextPage = hasNextPage;
    }
 
    /** 每页显示记录数 */
    private int everyPage;
 
    /** 总记录数 */
    private int totalCount;
 
    /** 总页数 */
    private int totalPage;
 
    /** 当前页 */
    private int currentPage;
 
    /** 查询起始点 */
    private int beginIndex;
 
    /** 是否有上一页 */
    private boolean hasPrePage;
 
    /** 是否有下一页 */
    private boolean hasNextPage;
}