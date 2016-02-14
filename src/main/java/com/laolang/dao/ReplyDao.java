package com.laolang.dao;
 
import java.sql.SQLException;
import java.util.List;
 
import com.laolang.db.Page;
import com.laolang.domain.Reply;
 
/**
 * 消息回复数据库操作接口
 * 
 * @author 小代码
 * @version 1.0
 */
public interface ReplyDao {
 
    /**
     * 插入回复
     *
     * @param reply
     *            消息回复对象
     * @throws SQLException
     *             the SQL exception
     */
    public void insertReply(Reply reply) throws SQLException;
 
    /**
     * 根据已发布消息的ID查找其所有回复
     *
     * @param messageID
     *            已发布消息的ID
     * @param page
     *            分页类对象
     * @return 查询到的回复消息
     * @throws SQLException
     *             the SQL exception
     */
    public List<Reply> selectReplyByMesageId(int messageID, Page page)
            throws SQLException;
 
    /**
     * 根据已发布的消息的ID查询其回复数
     *
     * @param messageID
     *            已发布消息的ID
     * @return 回复数
     * @throws SQLException
     *             the SQL exception
     */
    public int selectReplyCountByMessageId(int messageID) throws SQLException;
}