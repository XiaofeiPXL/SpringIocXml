package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.entity.Account;
import com.itheima.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: SpringIocXml
 * @description: 持久层接口实现类
 * @author: Xiaofei Wang
 * @created: 2020/09/29 20:52
 */


public class AccountDaoImpl implements AccountDao {


    private QueryRunner queryRunner;
    //提供构造函数方便Spring容器注入
    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public List<Account> findAll() {
        try {
            return queryRunner.query(connectionUtils.getThreadConnection(), "select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(), "insert into account(Name,money) values(?,?)" ,account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountByName(String username) {
        try {
            List<Account> account = queryRunner.query(connectionUtils.getThreadConnection(), "select * from account where name = ?",new BeanListHandler<Account>(Account.class),username);
            if(account.size()==0 || account==null){
                return null;
            }
            if(account.size()>1){
                throw new RuntimeException("结果不唯一,请确认数据后重新查询");
            }
            return account.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
