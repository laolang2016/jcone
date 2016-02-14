package com.laolang.daoImpl;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

import com.laolang.dao.EmployeeDao;
import com.laolang.domain.Employee;

public class EmployeeDaoTest {
	
	@Before
	public void setUp(){
		dao = new EmployeeDaoImpl();
	}
	
//	|       1001 | 老狼         | 男          | 1991-12-06    | 15382009723   | 中国          | 2005-05-18 | fcl1164891 |      0 |

	@SuppressWarnings("deprecation")
	@Test
	public void testSelect(){
		Employee emp = new Employee();
		emp.setEmployeeName("老狼");
		emp.setEmployeePhone("15382009723");
		emp.setEmployeeID(1001);
		
		try {
			Employee e = dao.selectById(1001);
			
			assertEquals("姓名不符",emp.getEmployeeName(), e.getEmployeeName());
			assertEquals("ID不符",emp.getEmployeeID(),e.getEmployeeID());
			assertEquals("姓名不符",emp.getEmployeePhone(), e.getEmployeePhone());
			System.out.println("emp:"+emp);
			System.out.println("e:"+e);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private EmployeeDao dao;

}
