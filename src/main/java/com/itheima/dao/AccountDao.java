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

    /**
     * 根据用户名查询账户
     * @param username 账户名称
     * @return 对应的唯一账户
     */
    Account findAccountByName(String username);

    /**
     * 修改账户信息
     * @param account 需要修改的账户信息
     */
    void updateAccount(Account account);
}
