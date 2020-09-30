package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.entity.Account;
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

    public List<Account> findAll() {
        try {
            return queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            queryRunner.update("insert into account(Name,money) values(?,?)" ,account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
