package com.laolang.dao;
 
import java.sql.SQLException;
 
import com.laolang.domain.Employee;
 
 
 
/**
 * Employee 数据库操作接口.
 * 
 * @author 小代码
 * @version 1.0
 */
public interface EmployeeDao {
 
    /**
     * 通过员工ID查找员工.
     * 
     * @param id
     *            员工ID
     * @return 查找到的员工对象
     * @throws SQLException
     *             the SQL exception
     */
    public Employee selectById(int id) throws SQLException;
}