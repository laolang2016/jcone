package com.laolang.servlet;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.laolang.dao.CriticismDao;
import com.laolang.dao.MessageDao;
import com.laolang.dao.ReplyDao;
import com.laolang.daoImpl.CriticismDaoImpl;
import com.laolang.daoImpl.MessageDaoImpl;
import com.laolang.daoImpl.ReplyDaoImpl;
import com.laolang.db.Page;
import com.laolang.db.PageUtil;
import com.laolang.domain.Criticism;
import com.laolang.domain.Message;
import com.laolang.domain.Reply;
 
/**
 * Servlet implementation class MessageContentServlet
 */
public class MessageContentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageContentServlet() {
        super();
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // 得到要查看的消息的ID
        int messageID = Integer.parseInt(request.getParameter("messageID"));
 
        // 查询消息
        MessageDao dao = new MessageDaoImpl();
        Message message = dao.selectMessageById(messageID);
 
        // 将消息保存到request
        request.setAttribute("message", message);
 
        // 查询当前消息对应的所有回复
            //当前在第几页
        int currentPage = 0;
        String currentPageStr = request.getParameter("currentPage");
 
        if (null == currentPageStr || currentPageStr.equals("")) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(currentPageStr);
        }
         
         
        try {
            //查询回复
            ReplyDao replyDao = new ReplyDaoImpl();
            Page page = PageUtil.createPage(5, replyDao.selectReplyCountByMessageId(messageID), currentPage);
            List<Reply> replyList = replyDao.selectReplyByMesageId(messageID, page);
             
            //将回复保存到request
            request.setAttribute("replyList", replyList);
            request.setAttribute("page", page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
 
        //查询当前消息对应的批复
        try {
            CriticismDao criDao = new CriticismDaoImpl();
            Criticism criticism = criDao.selectCriticismByMessageId(messageID);
            request.setAttribute("criticism", criticism);
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
        //页面跳转
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/showMessage.jsp");
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