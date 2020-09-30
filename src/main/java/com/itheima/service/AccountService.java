package com.itheima.service;

import com.itheima.entity.Account;

import java.util.List;

/**
 * @program: SpringIocXml
 * @description: Service层接口
 * @author: Xiaofei Wang
 * @created: 2020/09/29 20:46
 */


public interface AccountService {
    List<Account> findAll();

    void saveAccount(Account account);
}
