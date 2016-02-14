package com.laolang.dao;
 
import java.sql.SQLException;
 
import com.laolang.domain.Criticism;
 
/**
 * 消息批复数据库操作接口
 * 
 * @author 小代码
 * @version 1.0
 * 
 */
public interface CriticismDao {
 
    /**
     * 插入批复
     *
     * @param criticism
     *            要插入的批复对象
     * @throws SQLException
     *             the SQL exception
     */
    public void insertCriticism(Criticism criticism) throws SQLException;
 
    /**
     * 根据已发布消息的ID查找批复
     * @param criticism
     *            已发布消息的ID
     * @return 查找到的批复
     * @throws SQLException
     *             the SQL exception
     */
    public Criticism selectCriticismByMessageId( int messageID ) throws SQLException;
}