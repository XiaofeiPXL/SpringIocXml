package com.itheima.dao;

import com.itheima.entity.Account;

import java.util.List;

/**
 * @program: SpringIocXml
 * @description: 持久层接口
 * @author: Xiaofei Wang
 * @created: 2020/09/29 20:51
 */


public interface AccountDao {
    /**
     * 查询所有账户
     *
     * @return 对应的账户列表
     */
    List<Account> findAll();

    /**
     * 保存账户
     *
     * @param account 账户对象
     */
    void saveAccount(Account account);
}
