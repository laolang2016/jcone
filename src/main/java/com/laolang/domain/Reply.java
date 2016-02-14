package com.laolang.domain;
 
import java.util.Date;
 
/**
 * 消息回复类
 * 
 * @author 小代码
 * @version 1.0
 * 
 */
public class Reply {
 
    /**
     * Instantiates a new reply.
     */
    public Reply() {
        super();
    }
 
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Reply [replyID=" + replyID + ", replyContent=" + replyContent
                + ", employeeID=" + employeeID + ", replyTime=" + replyTime
                + ", messageID=" + messageID + "]";
    }
 
    /**
     * Gets the reply id.
     *
     * @return the reply id
     */
    public int getReplyID() {
        return replyID;
    }
 
    /**
     * Sets the reply id.
     *
     * @param replyID
     *            the new reply id
     */
    public void setReplyID(int replyID) {
        this.replyID = replyID;
    }
 
    /**
     * Gets the reply content.
     *
     * @return the reply content
     */
    public String getReplyContent() {
        return replyContent;
    }
 
    /**
     * Sets the reply content.
     *
     * @param replyContent
     *            the new reply content
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
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
     * Gets the reply time.
     *
     * @return the reply time
     */
    public Date getReplyTime() {
        return replyTime;
    }
 
    /**
     * Sets the reply time.
     *
     * @param replyTime
     *            the new reply time
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
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
 
    /** 回复ID */
    private int replyID;
 
    /** 回复内容 */
    private String replyContent;//
 
    /** 回复人ID */
    private int employeeID; //
 
    /** 回复时间 */
    private Date replyTime; //
 
    /** 消息ID */
    private int messageID; //
}