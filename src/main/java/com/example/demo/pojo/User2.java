package com.example.demo.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description:
 * @Author 罗曼蒂克
 * @Date Created in 8:43   2018/6/5
 */
@Data
public class User2 {

    private int id;//数据库存储id
    private String username;//用户名
    private String password;//密码
    private String loginname;//密码

    public User2(){}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

