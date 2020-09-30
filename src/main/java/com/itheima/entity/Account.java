package com.itheima.entity;

import java.io.Serializable;

/**
 * @program: SpringIocXml
 * @description: 账户实体类
 * @author: Xiaofei Wang
 * @created: 2020/09/29 20:48
 */


public class Account implements Serializable {
    private Integer id;
    private String name;
    private double money;

    public Account() {
    }

    public Account(Integer id, String name, double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
