package com.laolang.db;
 
/**
* 分页信息辅助类
* 
* @author 小代码
* @version 1.0
*/
public class PageUtil {
 
    /**
     * 创建分页信息对象
     *
     * @param everyPage
     *            每页显示消息数
     * @param totalCount
     *            总页数
     * @param currentPage
     *            当前页
     * @return the page
     */
    public static Page createPage(int everyPage, int totalCount, int currentPage) {
        everyPage = getEveryPage(everyPage);
        currentPage = getCurrentPage(currentPage);
        int totalPage = getTotalPage(everyPage, totalCount);
        int beginIndex = getBeginIndex(everyPage, currentPage);
        boolean hasPrePage = getHasPrePage(currentPage);
        boolean hasNextPage = getHasNextPage(totalPage, currentPage);
        return new Page(everyPage, totalCount, totalPage, currentPage,
                beginIndex, hasPrePage, hasNextPage);
    }
 
    /**
     * 获得每页显示记录数
     *
     * @param everyPage
     *            the every page
     * @return the every page
     */
    public static int getEveryPage(int everyPage) {
        return everyPage == 0 ? 10 : everyPage;
    }
 
    /**
     * 获得当前页
     *
     * @param currentPage
     *            the current page
     * @return the current page
     */
    public static int getCurrentPage(int currentPage) {
        return currentPage == 0 ? 1 : currentPage;
    }
 
    /**
     * 获得总页数
     *
     * @param everyPage
     *            the every page
     * @param totalCount
     *            the total count
     * @return the total page
     */
    public static int getTotalPage(int everyPage, int totalCount) {
        int totalPage = 0;
        if (totalCount != 0 && totalCount % everyPage == 0) {
            totalPage = totalCount / everyPage;
        } else {
            totalPage = totalCount / everyPage + 1;
        }
        return totalPage;
    }
 
    /**
     * 获得起始位置
     *
     * @param everyPage
     *            the every page
     * @param currentPage
     *            the current page
     * @return the begin index
     */
    public static int getBeginIndex(int everyPage, int currentPage) {
        return (currentPage - 1) * everyPage;
    }
 
    /**
     * 获得是否有上一页
     *
     * @param currentPage
     *            the current page
     * @return the checks for pre page
     */
    public static boolean getHasPrePage(int currentPage) {
        return currentPage == 1 ? false : true;
    }
 
    /**
     * 获得是否有上一页
     *
     * @param totalPage
     *            the total page
     * @param currentPage
     *            the current page
     * @return the checks for next page
     */
    public static boolean getHasNextPage(int totalPage, int currentPage) {
        return currentPage == totalPage || totalPage == 0 ? false : true;
    }
}