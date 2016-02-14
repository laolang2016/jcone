package com.laolang.domain;
 
import java.util.Date;
 
/**
 * 员工类
 *
 * @author 小代码
 * @version 1.0
 */
public class Employee {
	
	
	
 
    public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	public Employee(String employeeName, boolean employeeSex,
			Date employeeBirth, String employeePhone, String employeePlace,
			Date joinTime, String password, int isLead) {
		super();
		this.employeeName = employeeName;
		this.employeeSex = employeeSex;
		this.employeeBirth = employeeBirth;
		this.employeePhone = employeePhone;
		this.employeePlace = employeePlace;
		this.joinTime = joinTime;
		this.password = password;
		this.isLead = isLead;
	}



	/**
     * Gets the employee id.
     *
     * @return the employee id
     */
    public int getEmployeeID() {
        return employeeID;
    }
 
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Employee [employeeID=" + employeeID + ", employeeName="
                + employeeName + ", employeeSex=" + employeeSex
                + ", employeeBirth=" + employeeBirth + ", employeePhone="
                + employeePhone + ", employeePlace=" + employeePlace
                + ", joinTime=" + joinTime + ", password=" + password
                + ", isLead=" + isLead + "]";
    }
 
    /**
     * Sets the employee id.
     *
     * @param employeeID
     *            the new employee id
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
 
    /**
     * Gets the employee name.
     *
     * @return the employee name
     */
    public String getEmployeeName() {
        return employeeName;
    }
 
    /**
     * Sets the employee name.
     *
     * @param employeeName
     *            the new employee name
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
 
    /**
     * Checks if is employee sex.
     *
     * @return true, if is employee sex
     */
    public boolean isEmployeeSex() {
        return employeeSex;
    }
 
    /**
     * Sets the employee sex.
     *
     * @param employeeSex
     *            the new employee sex
     */
    public void setEmployeeSex(boolean employeeSex) {
        this.employeeSex = employeeSex;
    }
 
    /**
     * Gets the employee birth.
     *
     * @return the employee birth
     */
    public Date getEmployeeBirth() {
        return employeeBirth;
    }
 
    /**
     * Sets the employee birth.
     *
     * @param employeeBirth
     *            the new employee birth
     */
    public void setEmployeeBirth(Date employeeBirth) {
        this.employeeBirth = employeeBirth;
    }
 
    /**
     * Gets the employee phone.
     *
     * @return the employee phone
     */
    public String getEmployeePhone() {
        return employeePhone;
    }
 
    /**
     * Sets the employee phone.
     *
     * @param employeePhone
     *            the new employee phone
     */
    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }
 
    /**
     * Gets the employee place.
     *
     * @return the employee place
     */
    public String getEmployeePlace() {
        return employeePlace;
    }
 
    /**
     * Sets the employee place.
     *
     * @param employeePlace
     *            the new employee place
     */
    public void setEmployeePlace(String employeePlace) {
        this.employeePlace = employeePlace;
    }
 
    /**
     * Gets the join time.
     *
     * @return the join time
     */
    public Date getJoinTime() {
        return joinTime;
    }
 
    /**
     * Sets the join time.
     *
     * @param joinTime
     *            the new join time
     */
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
 
    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }
 
    /**
     * Sets the password.
     *
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
 
 
     
     
 
    public int getIsLead() {
        return isLead;
    }
 
    public void setIsLead(int isLead) {
        this.isLead = isLead;
    }
 
 
 
 
 
    /** 员工编号. */
    private int employeeID;
 
    /** 员工姓名. */
    private String employeeName;
 
    /** 员工性别. */
    private boolean employeeSex;
 
    /** 出生日期. */
    private Date employeeBirth;
 
    /** 办公室电话. */
    private String employeePhone;
 
    /** 住址. */
    private String employeePlace;
 
    /** 录入时间. */
    private Date joinTime;
 
    /** 系统口令. */
    private String password;
 
    /** 是否为管理层领导. */
    private int isLead;
}