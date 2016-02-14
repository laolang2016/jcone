package com.laolang.daoImpl;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
 
import com.laolang.dao.MessageDao;
import com.laolang.db.Page;
import com.laolang.db.laolangDB;
import com.laolang.domain.Message;
 
/**
 * 消息数据库操作接口
 * 
 * @author 小代码
 * @version 1.0
 */
public class MessageDaoImpl implements MessageDao {
 
    /**
     * Instantiates a new message dao impl.
     */
    public MessageDaoImpl() {
        runner = new QueryRunner();
    }
 
    /** 
     * 
     * 添加消息的方法
     *
     * @param message
     *            要添加的消息
     * @see com.laolang.dao.MessageDao#insertMessage(com.laolang.domain.Message)
     */
    @Override
    public void insertMessage(Message message) {
        String sqlInsert = "insert into tb_message values(?,?,?,?,?)";
        try {
            runner.update(laolangDB.getConnection(), sqlInsert,
                    message.getMessageID(), message.getMessageTitle(),
                    message.getMessageContent(), message.getEmployeeID(),
                    message.getPublishTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * 
     * 修改消息的方法
     *
     * @param message
     *            要修改的消息
     * @see com.laolang.dao.MessageDao#updateMessage(com.laolang.domain.Message)
     */
    @Override
    public void updateMessage(Message message) {
 
    }
 
    /**
     * 
     * 删除消息的方法
     *
     * @param messageID
     *            要删除的消息的ID
     * @see com.laolang.dao.MessageDao#deleteMessage(int)
     */
    @Override
    public void deleteMessage(int messageID) {
 
    }
 
    /**
     * 
     * 按分页信息查询所有消息的方法
     *
     * @param page
     *            分页
     * @return 查询到的消息列表
     * @see com.laolang.dao.MessageDao#selectMesssageAll(com.laolang.db.Page)
     */
    @Override
    public List<Message> selectMesssageAll(Page page) {
        List<Message> messageList = null;
        String selectAll = "select messageID,messageTitle,messageContent,employeeID,publishTime from tb_message order by publishTime desc limit ?,?";
        try {
            messageList = runner.query(laolangDB.getConnection(), selectAll,
                    new BeanListHandler<Message>(Message.class),page.getBeginIndex(),page.getEveryPage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageList;
    }
 
    /**
     * 
     * 按ID查询消息的方法
     *
     * @param messageID
     *            要查询的消息的ID
     * @return 查询到的消息ID
     * @see com.laolang.dao.MessageDao#selectMessageById(int)
     */
    @Override
    public Message selectMessageById(int messageID) {
        Message message = null;
         
        String select = "select messageID,messageTitle,messageContent,employeeID,publishTime from tb_message where messageID = ?";
        try {
            message = runner.query(laolangDB.getConnection(), select, new BeanHandler<Message>(Message.class),messageID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }
 
    /**
     * 查询消息记录数
     *
     * @return 消息总条数
     * @see com.laolang.dao.MessageDao#selectMessageCount()
     */
    @Override
    public int selectMessageCount() {
        Connection conn = laolangDB.getConnection();
        String sqlCount = "select count(messageID) from tb_message";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try{
            ps = conn.prepareStatement(sqlCount);
            rs = ps.executeQuery();
            if( rs.next() ){
                count = rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            laolangDB.closeConnection(rs, ps, conn);
        }
        return count;
    }
 
    /** The runner. */
    private QueryRunner runner;
 
}