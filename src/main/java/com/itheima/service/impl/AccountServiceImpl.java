package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.entity.Account;
import com.itheima.service.AccountService;

import java.util.List;

/**
 * @program: SpringIocXml
 * @description: 业务层接口实现类
 * @author: Xiaofei Wang
 * @created: 2020/09/29 20:57
 */


public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }
}
