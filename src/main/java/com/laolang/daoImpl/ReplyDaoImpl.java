package com.laolang.daoImpl;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
 
import com.laolang.dao.ReplyDao;
import com.laolang.db.Page;
import com.laolang.db.laolangDB;
import com.laolang.domain.Reply;
 
/**
 * 消息回复数据库操作实现
 * 
 * @author 小代码
 * @version 1.0
 */
public class ReplyDaoImpl implements ReplyDao {
 
    public ReplyDaoImpl() {
        runner = new QueryRunner();
    }
 
    /**
     * 插入回复
     *
     * @param reply
     *            消息回复对象
     * @throws SQLException
     *             the SQL exception
     * @see com.laolang.dao.ReplyDao#insertReply(com.laolang.domain.Reply)
     */
    @Override
    public void insertReply(Reply reply) throws SQLException {
        String sqlInsert = "insert into tb_reply values(?,?,?,?,?)";
        runner.update(laolangDB.getConnection(), sqlInsert, reply.getReplyID(),
                reply.getReplyContent(), reply.getEmployeeID(),
                reply.getReplyTime(), reply.getMessageID());
 
    }
 
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
     * @see com.laolang.dao.ReplyDao#selectReplyByMesageId(int,
     *      com.laolang.db.Page)
     */
    @Override
    public List<Reply> selectReplyByMesageId(int messageID, Page page)
            throws SQLException {
        String sql = "select replyID,replyContent,employeeID,replyTime,messageID from tb_reply where messageID=? limit ?,?";
        List<Reply> replyList = runner.query(laolangDB.getConnection(), sql,
                new BeanListHandler<Reply>(Reply.class), messageID,
                page.getBeginIndex(), page.getEveryPage());
        return replyList;
    }
 
    /**
     * 根据已发布的消息的ID查询其回复数
     *
     * @param messageID
     *            已发布消息的ID
     * @return 回复数
     * @throws SQLException
     *             the SQL exception
     * @see com.laolang.dao.ReplyDao#selectReplyCountByMessageId(int)
     */
    @Override
    public int selectReplyCountByMessageId(int messageID) throws SQLException {
        Connection conn = laolangDB.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        String sql = "select count(messageID) from tb_reply where messageID = ?";
         
        ps = conn.prepareStatement(sql);
        ps.setInt(1, messageID);
        rs = ps.executeQuery();
        if( rs.next() ){
            count = rs.getInt(1);
        }
        return count;
    }
 
    private QueryRunner runner;
}