<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业日常事务管理系统-查看具体消息</title>
<link href="css/layout.css" type="text/css" rel="stylesheet" />
<link href="css/content.css" type="text/css" rel="stylesheet" />
 
<!-- ckeditor -->
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript">
    //将ckeditor替换textarea
    //<![CDATA[    
    CKEDITOR.replace('content', {
        toolbar : 'MyToolbar',
        skin : 'kama'
    });
    //]]>
 
    //判断是输入内容是否为空
    function test() {
        var editor_data = CKEDITOR.instances.content.getData();
        if (editor_data == null || editor_data == "") {
            alert("请填写内容！");
            return false;
        }
    }
</script>
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
            <div class="message">
                <h2 align="center">${message.messageTitle}</h2>
                <hr />
                ${message.messageContent}
            </div>
             
            <!-- 领导批复 -->
            <div class="criticism">
            </div>
                <h5>领导批复：${empty criticism ? "暂无" : criticism.criticismContent }</h5>
            <hr />
             
            <!-- 员工回复 -->
            <div class="reply">
                <c:forEach items="${requestScope.replyList }" var="reply">
                    <div class="reply_content">
                        ${reply.replyContent }
                        <div class="reply_employeeID_replyTime">
                            回复人ID：${reply.employeeID }
                            回复时间：${reply.replyTime }
                        </div>
                    </div>
                    <hr />
                </c:forEach>
                 
                <div class="pages">
                    第
                    <c:forEach varStatus="stat" begin="1" end="${page.totalPage }">
                        <a href="MessageContextServlet?messageID=${message.messageID }&currentPage=${stat.index}">${stat.index }</a>
                    </c:forEach>
                    页
                </div>
            </div>
             
            <!-- 回复输入框 -->
            <div class="reply_input">
                <p>回复：</p>
                <!-- 身份识别的提示 -->
                <p>
                    <font color="red">${requestScope.replyError }</font>
                </p>
                 
                <form action="ReplyServlet" method="post">
                    <p>
                        <font color="red">${requestScope.replyNoContentError }</font>
                    </p>
                    <textarea id="content" name="replyContent" class="ckeditor"cols="80" rows="10">
                                 
                    </textarea>
                    <input type="hidden" name="messageID" value="${message.messageID }" /> 
                    <br /> 
                    <input type="submit" value="提交" /> 
                    <input type="reset" value="重置" />
                </form>
            </div>
             
            <!-- 批复输入框 -->
            <c:if test="${sessionScope.employee.isLead == 1}">
                <div class="critisim_input">
                    <p>
                        <font color="red">${criticismError }</font>
                    </p>
                    <p>批复：</p>
                    <form action="CriticismServlet" method="post">
                        <input type="text" name="critisim_input" />
                        <input type="hidden" name="messageID" value="${message.messageID}" />
                        <br />
                        <input type="submit" value="提交" /> 
                        <input type="reset" value="重置" />
                    </form>
                </div>
            </c:if>
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