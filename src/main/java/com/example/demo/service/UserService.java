package com.example.demo.service;

import com.example.demo.mapper.UserMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;

/**
 * @Description:
 * @Author 罗曼蒂克
 * @Date Created in 10:33   2018/6/6
 */
@Service
public class UserService {

@Async//异步调用
    public void  test01(){

        System.out.println("message3");
        for (int i=1;i<=3;i++){
            System.out.println("i:"+i);
        }
        System.out.println("message4");
    }
}
