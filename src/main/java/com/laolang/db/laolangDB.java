package com.laolang.db;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ResourceBundle;
 
/**
 * 数据库连接和关闭工具类
 */
public class laolangDB {
 
    /** 数据库连接地址 */
    private static String URL;
 
    /** 数据库用户名 */
    private static String USERNAME;
 
    /** 数据库密码 */
    private static String USERPASSWORD;
 
    /** mysql 驱动 */
    private static String DRIVER;
 
    /** The rb. */
//    private static ResourceBundle rb = ResourceBundle
//            .getBundle("com.laolang.db.db-config");
 
    /**
     * 使用静态代码块加载驱动
     */
    static {
//        URL = rb.getString("jdbc.url");
//        USERNAME = rb.getString("jdbc.username");
//        USERPASSWORD = rb.getString("jdbc.userpassword");
//        DRIVER = rb.getString("jdbc.driver");
        
        URL = "jdbc:mysql://localhost:3306/jc_one?useUnicode=true&characterEncoding=UTF-8";
        USERNAME = "root";
        USERPASSWORD = "root";
        DRIVER = "com.mysql.jdbc.Driver";
 
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * 获得链接.
     *
     * @return the connection
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return conn;
    }
 
    /**
     * 关闭链接.
     *
     * @param rs            the rs
     * @param ps            the ps
     * @param conn            the conn
     */
    public static void closeConnection(ResultSet rs, Statement ps,
            Connection conn) {
        try {
            if (null != rs)
                rs.close();
            if (null != ps)
                ps.close();
            if (null != conn)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}