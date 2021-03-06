package com.itheima.service;

import com.itheima.entity.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 * @program: SpringIocXml
 * @description:
 * @author: Xiaofei Wang
 * @created: 2020/09/29 21:06
 */


public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    @Before
    public void setUp(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService = applicationContext.getBean("accountService",AccountService.class);
        System.out.println("Test is start...");
    }

    @After
    public void tearDown(){
        System.out.println("Test is done");
    }


    @Test
    public void testFindAll() {
        List<Account> accountList = accountService.findAll();
        for(Account account:accountList){
            System.out.println(account);
        }
    }

    @Test
    public void saveAccount() {
        Account account = new Account();
        account.setName("xiaolin");
        account.setMoney(10000d);
        accountService.saveAccount(account);
    }

    @Test
    public void transfer(){
        accountService.transfer("test","huahua",2345d);
    }

    @Test
    public void updateAccount() {
        Account account = new Account();
        account.setId(6);
        account.setName("大橘");
        account.setMoney(12345d);
        accountService.updateAccount(account);
    }
}