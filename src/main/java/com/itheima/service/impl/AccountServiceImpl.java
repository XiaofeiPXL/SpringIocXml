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

    public void transfer(String sourceName, String targetName, Double money) {
        //确定转出账户
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        //确定转入账户
        Account targetAccount = accountDao.findAccountByName(targetName);
        //修改转出账户金额
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        //修改转入账户金额
        targetAccount.setMoney(targetAccount.getMoney() + money);
        //保存更改
        accountDao.updateAccount(sourceAccount);
        accountDao.updateAccount(targetAccount);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }
}
