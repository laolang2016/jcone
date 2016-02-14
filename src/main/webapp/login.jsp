<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业日常事务管理系统-身份识别</title>
<link href="css/layout.css" type="text/css" rel="stylesheet" />
<link href="css/content.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript" src="js/myjs.js"></script>
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
                    <li><a href="messageList.jsp">消息列表</a></li>
                    <li class="li_space"></li>
                    <li><a href="publishNewMessage.jsp">发布新消息</a></li>
                    <li class="li_space"></li>
                    <li><a href="#">身份识别</a></li>
                </ul>
            </div>
        </div>
         
        <div class="empty_bar"></div>
         
        <!-- 内容容器 -->
        <div class="content content_messageList">
             
            <form class="login" method="post" action="loginServlet">
                员工身份识别
                <br />
                <font color="red">${requestScope.loginError }</font>
                <br />
                员工编号：
                <input id="user_id" type="text" name="userID" class="text_login"/>
                <br />
                系统口令：
                <input id="user_pwd" type="password" name="userPwd" class="text_login"/>
                <br />
                <input type="submit" value="提交"/>
                <input type="reset" value="重置" />
            </form>
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