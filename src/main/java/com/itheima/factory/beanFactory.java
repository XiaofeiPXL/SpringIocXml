package com.itheima.factory;

import com.itheima.service.AccountService;
import com.itheima.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: SpringIocXml
 * @description: 代理对象的创建工厂
 * @author: Xiaofei Wang
 * @created: 2020/09/30 19:05
 */


public class beanFactory {
    private AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 创建AccountService的代理对象
     * @return 经过动态代理加强过的accountService对象
     */
    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue;
                try{
                    //前置通知
                    transactionManager.beginTransaction();
                    //明确的切入点方法调用
                    returnValue = method.invoke(accountService,args);
                    //后置通知
                    transactionManager.CommitTransaction();
                    return returnValue;
                }catch(Exception e){
                    //异常通知
                    transactionManager.RollbackTransaction();
                    throw new RuntimeException(e);
                }finally{
                    //最终通知
                    transactionManager.closeTransaction();
                }
            }
        });
    }
}
