<%@page import="com.laolang.domain.Message"%>
<%@page import="java.util.List"%>
<%@page import="com.laolang.db.Page"%>
<%@page import="com.laolang.db.PageUtil"%>
<%@page import="com.laolang.daoImpl.MessageDaoImpl"%>
<%@page import="com.laolang.dao.MessageDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业日常事务管理系统-首页</title>
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
                    <li><a href="#">首页</a></li>
                    <li class="li_space"></li>
                    <li><a href="MessageListServlet">消息列表</a></li>
                    <li class="li_space"></li>
                    <li><a href="publishNewMessage.jsp">发布新消息</a></li>
                    <li class="li_space"></li>
                    <li><a href="login.jsp">身份识别</a></li>
                </ul>
            </div>
        </div>
         
        <div class="empty_bar"></div>
         
        <!-- 内容容器 -->
        <div class="content">
            <!-- 员工信息 -->
            <div class="employeeinfo">
             
                <!-- 员工信息标题 -->
                <div class="tit">
                    <h3>员工信息</h3>
                </div>
                 
                <!-- 信息 -->
                <div class="info">
                    <c:choose>
                        <c:when test="${empty sessionScope.employee }">
                            没有身份识别
                        </c:when>
                        <c:otherwise>
                            <ul>
                                <li>员工编号：${employee.employeeID }</li>
                                <li>员工姓名：${employee.employeeName }</li>
                                <li>员工性别：${employee.employeeSex ? "男" : "女"}</li>
                                <li>出生日期：${employee.employeeBirth }</li>
                                <li>办公室电话：${employee.employeePhone }</li>
                                <li>员工住址：${employee.employeePlace }</li>
                                <li>是否管理层领导：${employee.isLead == 1 ? '是' : '否'}</li>
     
                            </ul>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
             
            <!-- 最新消息列表 -->
            <div class="messagelist">
             
                <!-- 最新消息 -->
                <div class="tit">
                    <h3>最新消息</h3>
                </div>
                 
                <!-- 消息列表 -->
                <div class="list">
                        <%
                            MessageDao dao = new MessageDaoImpl();
                            Page pageX = PageUtil.createPage(5, dao.selectMessageCount(), 1);
                             
                            List<Message> messageList = dao.selectMesssageAll(pageX);
                             
                            for( Message message : messageList){
                        %>
                            <p><a href="MessageContentServlet?messageID=<%=message.getMessageID()%>"><%=message.getMessageTitle()%></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;<span><%=message.getPublishTime()%></span></p>
                        <%
                            }
                        %>
                </div>
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

