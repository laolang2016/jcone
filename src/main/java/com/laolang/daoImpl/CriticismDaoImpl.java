package com.laolang.daoImpl;
 
import java.sql.SQLException;
 
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
 
import com.laolang.dao.CriticismDao;
import com.laolang.db.laolangDB;
import com.laolang.domain.Criticism;
 
/**
 * 消息批复数据库操作实现
 * 
 * @author 小代码
 * @version 1.0
 */
public class CriticismDaoImpl implements CriticismDao {
 
    public CriticismDaoImpl() {
        runner = new QueryRunner();
    }
 
    /**
     * 插入批复
     *
     * @param criticism
     *            要插入的批复对象
     * @throws SQLException
     *             the SQL exception
     * @see com.laolang.dao.CriticismDao#insertCriticism(com.laolang.domain.Criticism)
     */
    @Override
    public void insertCriticism(Criticism criticism) throws SQLException {
        String sql = "insert into tb_criticism (criticismContent,employeeID,criticismTime,messageID) values(?,?,?,?)";
        runner.update(laolangDB.getConnection(), sql,
                criticism.getCriticismContent(), criticism.getEmployeeID(),
                criticism.getCriticismTime(), criticism.getMessageID());
    }
 
    /**
     * 根据已发布消息的ID查找批复
     * 
     * @param criticism
     *            已发布消息的ID
     * @return 查找到的批复
     * @throws SQLException
     *             the SQL exception
     * @see com.laolang.dao.CriticismDao#selectCriticismByMessageId()
     */
    @Override
    public Criticism selectCriticismByMessageId(int messageID)
            throws SQLException {
        String sql = "select criticismContent,employeeID,criticismTime,messageID from tb_criticism where messageID=?";
        Criticism criticism = runner.query(laolangDB.getConnection(), sql,
                new BeanHandler<Criticism>(Criticism.class), messageID);
 
        return criticism;
    }
 
    private QueryRunner runner;
 
}