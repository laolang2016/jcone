<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业日常事务管理系统-消息列表</title>
<link href="css/layout.css" type="text/css" rel="stylesheet" />
<link href="css/content.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <!-- 总容器 -->
    <div class="container">
        <!-- 头部 -->
        <div class="header">
            <!-- 网站logo -->
            <div class="logo">
            </div>
             
            <!-- 广告位 -->
            <div class="banner">
            </div>
             
            <div class="empty_bar"></div>
             
            <!-- 导航菜单 -->
            <div class="nav">
                <ul>
                    <li><a href="index.jsp">首页</a></li>
                    <li class="li_space"></li>
                    <li><a href="#">消息列表</a></li>
                    <li class="li_space"></li>
                    <li><a href="publishNewMessage.jsp">发布新消息</a></li>
                    <li class="li_space"></li>
                    <li><a href="login.jsp">身份识别</a></li>
                </ul>
            </div>
        </div>
         
        <div class="empty_bar"></div>
         
        <!-- 内容容器 -->
        <div class="content content_messageList">
            <c:forEach items="${requestScope.messageList }" var="message">
                <p class = "list_tit">>><a href="MessageContentServlet?messageID=${message.messageID }">${message.messageTitle }</a></p>
                <p class="list_id_time">发布人ID：${message.employeeID }&nbsp;&nbsp;发布时间：${message.publishTime }</p>
                <hr  />   
            </c:forEach>
             
            <!-- 分页 -->
            <div class="pages">
                <c:choose>
                    <c:when test="${page.hasPrePage }">
                        <a href="MessageListServlet?currentPage=1">首页</a> |
                        <a href="MessageListServlet?currentPage=${page.currentPage - 1}">上一页</a> |
                    </c:when>
                    <c:otherwise>
                        首页|上一页
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${page.hasNextPage }">
                        <a href="MessageListServlet?currentPage=${page.currentPage + 1}">下一页</a> |
                        <a href="MessageListServlet?currentPage=${page.totalPage}">尾页</a>
                    </c:when>
                    <c:otherwise>
                        下一页|尾页
                    </c:otherwise>
                </c:choose>
                当前为第${page.currentPage}页,共${page.totalPage}页
            </div>
        </div>
         
        <div class="empty_bar"></div>
         
        <!-- 版权部分 -->
        <div class="footer">
            <ul>
                <li>企业日常事务管理系统 &nbsp;&copy;by 小代码</li>
            </ul>
        </div>
     
    </div>
</body>
</html>