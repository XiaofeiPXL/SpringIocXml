package com.itheima.utils;

import java.sql.SQLException;

/**
 * @program: SpringIocXml
 * @description: 事务管理类
 * @author: Xiaofei Wang
 * @created: 2020/09/30 18:59
 */


public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务,关闭事务的自动提交
     */
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void CommitTransaction() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void RollbackTransaction() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接,解绑线程和数据库连接
     */
    public void closeTransaction() {
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
