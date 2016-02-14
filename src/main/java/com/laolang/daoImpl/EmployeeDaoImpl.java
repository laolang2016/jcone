package com.laolang.daoImpl;
 
import java.sql.SQLException;
 
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
 
import com.laolang.dao.EmployeeDao;
import com.laolang.db.laolangDB;
import com.laolang.domain.Employee;
 
/**
 * employee 数据库操作接口实现
 * 
 * @author 小代码
 * @version 1.0
 */
public class EmployeeDaoImpl implements EmployeeDao {
     
     
 
    /**
     * Instantiates a new employee dao impl.
     */
    public EmployeeDaoImpl() {
        super();
        runner = new QueryRunner();
    }
 
    /** 
     * 根据id查询员工信息 
     * 
     * @param id
     *      员工ID
     * @return
     *      查询到的员工对象
     * 
     * @see com.laolang.dao.EmployeeDao#selectById(int)
     */
    @Override
    public Employee selectById(int id) throws SQLException {
        Employee emp = null;
        String selectById = "select employeeID,employeeName,employeeSex,"
                + "employeeBirth,employeePhone,employeePlace,joinTime,password,isLead "
                + "from tb_employee where employeeID=?";
        emp = runner.query(laolangDB.getConnection(), selectById, new BeanHandler<Employee>(Employee.class), id);
        return emp;
    }
 
    /** The runner. */
    private QueryRunner runner;
}