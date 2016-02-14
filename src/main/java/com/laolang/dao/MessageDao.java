package com.laolang.dao;
 
import java.util.List;
 
import com.laolang.db.Page;
import com.laolang.domain.Message;
 
/**
 * 消息数据库操作接口
 * 
 * @author 小代码
 * @version 1.0
 */
public interface MessageDao {
 
    /**
     * 添加消息的方法
     *
     * @param message
     *            要添加的消息
     */
    public void insertMessage(Message message);
 
    /**
     * 修改消息的方法
     *
     * @param message
     *            要修改的消息
     */
    public void updateMessage(Message message);
 
    /**
     * 删除消息的方法
     *
     * @param messageID
     *            要删除的消息的ID
     */
    public void deleteMessage(int messageID);
 
    /**
     * 按分页信息查询所有消息的方法
     *
     * @param page
     *            分页
     * @return 查询到的消息列表
     */
    public List<Message> selectMesssageAll(Page page);
 
    /**
     * 按ID查询消息的方法
     *
     * @param messageID
     *            要查询的消息的ID
     * @return 查询到的消息ID
     */
    public Message selectMessageById(int messageID);
 
    /**
     * 查询消息记录数
     *
     * @return 消息总条数
     */
    public int selectMessageCount();
}