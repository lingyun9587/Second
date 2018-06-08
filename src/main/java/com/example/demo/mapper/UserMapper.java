package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:测试帐号的接口数据访问层
 * @Author 罗曼蒂克
 * @Date Created in 14:05   2018/4/25
 */

public interface UserMapper extends JpaRepository<User,Integer> {



}
