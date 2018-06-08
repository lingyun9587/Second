package com.example.demo.mapper;

import com.example.demo.pojo.User;
import com.example.demo.pojo.User2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author 罗曼蒂克
 * @Date Created in 11:03   2018/6/5
 */
@Mapper
@Component
public interface UserMapper2 {



    @Select("SELECT id,loginName, userName,easybuy_user.password  FROM  easybuy_user")
    //@Transactional
    List<User2> userLlist();


}
