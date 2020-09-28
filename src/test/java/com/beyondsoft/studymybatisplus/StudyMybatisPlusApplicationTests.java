package com.beyondsoft.studymybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beyondsoft.mybatisplus.MybatisPlusApplication;
import com.beyondsoft.mybatisplus.entity.User;
import com.beyondsoft.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
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

    @Test
    void addUser(){
        User user = new User();
        user.setName("zhaoliu");
        user.setAge(20);
        user.setEmail("123@qq.com");
        userMapper.insert(user);
    }

    @Test
    void updateUser(){
        User user = new User();
        user.setId(1310456551164649473L);
        user.setAge(100);
        userMapper.updateById(user);
    }

    @Test
    void testOptimisticLocker(){
        User user = userMapper.selectById(1310486739126603777L);
        user.setAge(100);
        userMapper.updateById(user);
    }

    @Test
    void testSelectBach(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L,2L,3L));
        System.out.println(users);
    }

    @Test
    void testSelectByMap(){
        HashMap<String,Object> map= new HashMap<>();
        map.put("name","Jone");
        map.put("age",18);
        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);
    }

    @Test
    void testPage(){
        Page<User> page =new Page<>(1,3);
        userMapper.selectPage(page, null);
        System.out.println(page.getCurrent()); //当前页
        System.out.println(page.getRecords());  //每页数据list集合
        System.out.println(page.getSize());     //每页显示记录数
        System.out.println(page.getTotal());    //总记录数
        System.out.println(page.hasNext());     //是否有下一页
        System.out.println(page.hasPrevious());     //是否有上一页
    }

    @Test
    void testDeleteById(){
        int result = userMapper.deleteById(1310506882154119170L);
        System.out.println(result);
    }
}
