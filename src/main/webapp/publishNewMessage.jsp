<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业日常事务管理系统-发布新消息</title>
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
        <div class="content content_messageList">
            <div class="newmessage">          
                <form action="PublishNewMessageServlet" method="post">    
                    <p>
                        <font color="red">${requestScope.publishNewMessageError}</font>
                    </p>
                                 
                    消息标题：<input type="text" name="messageTitle"/>
                    <br />
                    消息内容：
                    <textarea id="content" name="messageContent" class="ckeditor" cols="50" rows="10" >                   
                    </textarea>
                    <div class="newmessage_submit">
                        <input type="submit" value="提交">
                        <input type="reset" value="重置"/>
                    </div>
                </form>
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