package com.itheima.utils;


import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @program: SpringIocXml
 * @description: 数据库线程池工具类
 * @author: Xiaofei Wang
 * @created: 2020/09/30 18:46
 */


public class ConnectionUtils {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection() {
       try{
           //从thread上获取连接
           Connection connection = threadLocal.get();
           if(connection==null){
               //从数据源上获取一个新的连接,并绑定到当前线程上
               connection = dataSource.getConnection();
               threadLocal.set(connection);
           }
           return connection;
       }catch(Exception e){
           throw new RuntimeException(e);
       }
    }

    /**
     * 连接和线程解绑
     */
    public void removeConnection(){
        threadLocal.remove();
    }
}
