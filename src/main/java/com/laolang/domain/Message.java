package com.laolang.domain;
import java.util.Date;
 
/**
 * 消息类
 * 
 * @author 小代码
 * @version 1.0
 */
public class Message {
 
    /**
     * Gets the message id.
     *
     * @return the message id
     */
    public int getMessageID() {
        return messageID;
    }
 
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Message [messageID=" + messageID + ", messageTitle="
                + messageTitle + ", messageContent=" + messageContent
                + ", employeeID=" + employeeID + ", publishTime=" + publishTime
                + "]";
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
 
    /**
     * Gets the message title.
     *
     * @return the message title
     */
    public String getMessageTitle() {
        return messageTitle;
    }
 
    /**
     * Sets the message title.
     *
     * @param messageTitle
     *            the new message title
     */
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }
 
    /**
     * Gets the message content.
     *
     * @return the message content
     */
    public String getMessageContent() {
        return messageContent;
    }
 
    /**
     * Sets the message content.
     *
     * @param messageContent
     *            the new message content
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
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
     * Gets the publish time.
     *
     * @return the publish time
     */
    public Date getPublishTime() {
        return publishTime;
    }
 
    /**
     * Sets the publish time.
     *
     * @param publishTime
     *            the new publish time
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
 
    /** 消息ID */
    private int messageID;
 
    /** 消息标题 */
    private String messageTitle;
 
    /** 消息内容 */
    private String messageContent;
 
    /** 发布人ID */
    private int employeeID;
 
    /** 发布时间 */
    private Date publishTime;
}