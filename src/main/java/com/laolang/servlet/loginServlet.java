package com.laolang.servlet;
 
import java.io.IOException;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.laolang.dao.EmployeeDao;
import com.laolang.daoImpl.EmployeeDaoImpl;
import com.laolang.domain.Employee;
 
/**
 * Servlet implementation class loginServlet
 * 登陆验证
 * @version 1.2.1
 * @author 小代码
 */
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到用户输入的编号和密码
        String userID = request.getParameter("userID");
        String userPwd = request.getParameter("userPwd");
        int id = Integer.parseInt(userID);
         
        Employee emp = null;
        EmployeeDao dao = new EmployeeDaoImpl();
        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = null;
         
        try {
            //查询数据库
            emp = dao.selectById(id);
             
            //如果不存在该员工，则返回登陆页面并提示
            if( null == emp ){
                request.setAttribute("loginError", "该员工编号不存在");//员工编号不存在，则跳回登陆页面
                dispatcher = servletContext.getRequestDispatcher("/login.jsp");
            }else if( !userPwd.equals(emp.getPassword())){//如果密码不正确，则返回登陆页面并提示
                request.setAttribute("loginError", "登陆密码不正确");
                dispatcher = servletContext.getRequestDispatcher("/login.jsp");
            }else{ //ID和密码都正确，则跳到首页
                request.getSession().setAttribute("employee", emp);
                response.sendRedirect("index.jsp");
                return ;
            }
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
        //页面跳转
        dispatcher.forward(request, response);
         
         
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request,response);
    }
 
}