package com.beyondsoft.studymybatisplus;

import com.beyondsoft.mybatisplus.MybatisPlusApplication;
import com.beyondsoft.mybatisplus.entity.User;
import com.beyondsoft.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = MybatisPlusApplication.class)
class StudyMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void fidAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
