package com.laolang.servlet;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.laolang.dao.ReplyDao;
import com.laolang.daoImpl.ReplyDaoImpl;
import com.laolang.domain.Employee;
import com.laolang.domain.Reply;
 
/**
 * Servlet implementation class ReplyServlet
 */
public class ReplyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
        super();
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // 获取回复内容
        String replyContent = request.getParameter("replyContent");
        int messageID = Integer.parseInt(request.getParameter("messageID"));
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = null;
 
        // 从session中获取员工对象
        Employee emp = (Employee) request.getSession().getAttribute("employee");
 
        // 如果未登陆
        if (null == emp) {
            request.setAttribute("replyError", "发布回复前必须先进行身份识别");
        } else {
            if (null == replyContent || replyContent.equals("")) {// 如果回复内容为空，则提示其输入回复内容
                request.setAttribute("replyNoContentError", "发布回复前必须先进行身份识别");
            } else {
                // 创建回复对象
                Reply reply = new Reply();
                reply.setEmployeeID(emp.getEmployeeID());
                reply.setReplyContent(replyContent);
                reply.setMessageID(messageID);
                reply.setReplyTime(new Date());
 
                // 将回复内容插入数据库
                ReplyDao dao = new ReplyDaoImpl();
                try {
                    dao.insertReply(reply);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
 
        dispatcher = context.getRequestDispatcher("/MessageContentServlet?messageID="+ messageID);
        dispatcher.forward(request, response);
 
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
 
}

