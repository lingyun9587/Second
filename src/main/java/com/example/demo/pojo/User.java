package com.example.demo.pojo;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description:
 * @Author 罗曼蒂克
 * @Date Created in 8:43   2018/6/5
 */
@Entity(name="easybuy_user")
public class User {

    /**
     * 私有字段
     */

    @Id
    @GeneratedValue
    private int id;//数据库存储id
    @Column(name = "username")
    private String username;//用户名
    @Column(name = "password")
    private String password;//密码
    @Column(name = "loginname")
    private String loginname;//密码
    public String getUsernme() {
        return username;
    }

    public void setUsernme(String usernme) {
        this.username = usernme;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

/*private String identityCode;//身份证号
    private String email;//邮箱
    private String mobile;//手机号
    private int type;//类型（1：后台 0:前台）*/

    /**
     * 构造方法
     */
    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

