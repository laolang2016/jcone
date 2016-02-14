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
 
import com.laolang.dao.CriticismDao;
import com.laolang.daoImpl.CriticismDaoImpl;
import com.laolang.domain.Criticism;
import com.laolang.domain.Employee;
 
/**
 * Servlet implementation class CriticismServlet
 */
public class CriticismServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriticismServlet() {
        super();
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        //获取批复内容
        String criContent = request.getParameter("critisim_input");
         
        int messageID = Integer.parseInt(request.getParameter("messageID"));
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = null;
 
        Employee emp = (Employee) request.getSession().getAttribute("employee");
        Criticism cri = new Criticism();
        //如果未登陆，则提示其登陆
        if (null == emp) {
            request.setAttribute("criticismError", "进行批复前请登陆 ");
        } else {
            //如果未输入批复内容，则批复其输入批复内容
            if (null == criContent || criContent.equals("")) {
                request.setAttribute("criticismError", "进行输入批复内容");
            } else {
                //创建批复对象
                 
                cri.setCriticismContent(criContent);
                cri.setEmployeeID(emp.getEmployeeID());
                cri.setMessageID(messageID);
                cri.setCriticismTime(new Date());
 
                //将批复插入数据库中
                CriticismDao criDao = new CriticismDaoImpl();
                try {
                    criDao.insertCriticism(cri);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
 
        dispatcher = context
                .getRequestDispatcher("/MessageContentServlet?messageID="
                        + messageID);
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