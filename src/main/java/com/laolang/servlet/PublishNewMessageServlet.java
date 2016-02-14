package com.laolang.servlet;
 
import java.io.IOException;
import java.util.Date;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.laolang.dao.MessageDao;
import com.laolang.daoImpl.MessageDaoImpl;
import com.laolang.domain.Employee;
import com.laolang.domain.Message;
 
/**
 * 发布消息处理
 * 
 * @author 小代码
 * @version 1.0
 */
public class PublishNewMessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishNewMessageServlet() {
        super();
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = null;
         
        //获取员工输入的消息标题和内容
        String messageTitle = request.getParameter("messageTitle");
        String messageContext = request.getParameter("messageContent");
         
        //确定是哪个员工发布消息
        Employee emp = (Employee)request.getSession().getAttribute("employee");
         
        if( null == emp ){//如果员工未登陆，则跳回消息发布页面，并提示其进行登陆
            request.setAttribute("publishNewMessageError", "发布消息前必须进行身份识别");
            dispatcher = context.getRequestDispatcher("/publishNewMessage.jsp");
        }else{
            if( null == messageTitle || messageTitle.equals("")){//如果员工未输入消息，则跳回消息发布页面，并提示其输入标题
                request.setAttribute("publishNewMessageError", "请输入标题");
                dispatcher = context.getRequestDispatcher("/publishNewMessage.jsp");
            }else{
                //创建消息对象
                Message message = new Message();
                message.setMessageTitle(messageTitle);
                message.setMessageContent(messageContext);
                message.setPublishTime(new Date());
                message.setEmployeeID(emp.getEmployeeID());
                 
                //插入数据库
                MessageDao dao = new MessageDaoImpl();
                dao.insertMessage(message);
                 
                //跳转到消息列表的 servlet
                dispatcher = context.getRequestDispatcher("/MessageListServlet");
                 
            }
        }
         
        dispatcher.forward(request, response);
         
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
 
}