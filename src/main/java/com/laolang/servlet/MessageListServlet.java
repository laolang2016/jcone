package com.laolang.servlet;
 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.laolang.dao.MessageDao;
import com.laolang.daoImpl.MessageDaoImpl;
import com.laolang.db.Page;
import com.laolang.db.PageUtil;
import com.laolang.domain.Message;
 
/**
 * Servlet implementation class MessageListServlet
 */
public class MessageListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageListServlet() {
        super();
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        // 当前页数
        int currentPage = 0;
        String currentPageStr = request.getParameter("currentPage");// 获得当前页数
        if (null == currentPageStr || currentPageStr.equals("")) {// 如果不存在，则赋值为 1
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(currentPageStr);
        }
         
        //查询要显示的那一页
        MessageDao dao = new MessageDaoImpl();
        Page page = PageUtil.createPage(5, dao.selectMessageCount(), currentPage);
        List<Message> messageList = dao.selectMesssageAll(page);
         
        //将查询结果保存到request
        request.setAttribute("messageList", messageList);
        request.setAttribute("page", page);
         
        //页面跳转
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/messageList.jsp");
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