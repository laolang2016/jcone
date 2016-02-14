package com.laolang.domain;
 
import java.util.Date;
 
/**
 * 消息批复类
 * 
 * @author 小代码
 * @version 1.0
 */
public class Criticism {
 
    /**
     * Instantiates a new criticism.
     */
    public Criticism() {
        super();
    }
 
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Criticism [criticismID=" + criticismID + ", criticismContent="
                + criticismContent + ", employeeID=" + employeeID
                + ", criticismTime=" + criticismTime + ", messageID="
                + messageID + "]";
    }
 
    /**
     * Gets the criticism id.
     *
     * @return the criticism id
     */
    public int getCriticismID() {
        return criticismID;
    }
 
    /**
     * Sets the criticism id.
     *
     * @param criticismID
     *            the new criticism id
     */
    public void setCriticismID(int criticismID) {
        this.criticismID = criticismID;
    }
 
    /**
     * Gets the criticism content.
     *
     * @return the criticism content
     */
    public String getCriticismContent() {
        return criticismContent;
    }
 
    /**
     * Sets the criticism content.
     *
     * @param criticismContent
     *            the new criticism content
     */
    public void setCriticismContent(String criticismContent) {
        this.criticismContent = criticismContent;
    }
 
    /**
     * Gets the employee id.
     *
     * @return the employee id
     */
    public int getEmployeeID() {
        return employeeID;
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
     * Gets the criticism time.
     *
     * @return the criticism time
     */
    public Date getCriticismTime() {
        return criticismTime;
    }
 
    /**
     * Sets the criticism time.
     *
     * @param criticismTime
     *            the new criticism time
     */
    public void setCriticismTime(Date criticismTime) {
        this.criticismTime = criticismTime;
    }
 
    /**
     * Gets the message id.
     *
     * @return the message id
     */
    public int getMessageID() {
        return messageID;
    }
 
    /**
     * Sets the message id.
     *
     * @param messageID
     *            the new message id
     */
    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }
 
    /** 批复ID */
    private int criticismID;
 
    /** 批复内容 */
    private String criticismContent;
 
    /** 批复人ID */
    private int employeeID;
 
    /** 批复时间 */
    private Date criticismTime;
 
    /** 消息ID */
    private int messageID;
}