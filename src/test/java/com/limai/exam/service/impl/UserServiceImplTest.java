package com.limai.exam.service.impl;

import com.limai.exam.entity.User;
import com.limai.exam.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserServiceImplTest {
    @Autowired
    private UserService userService;


    @Test
    public void findById() {
        User user = userService.findById(1);
        log.info(user.toString());
    }

    @Test
    public void save() {
        User user = new User();
        user.setUsername("jhg");
        int save = userService.save(user);
        log.info("插入的新的user={}", user);

    }

    @Test
    public void findAll() {
        List<User> all = userService.findAll();
        all.forEach(user -> log.info(user.toString()));
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(2);
        user.setUsername("ooooooooo");
        int save = userService.updateById(user);

    }

    @Test
    public void deleteByIdList() {

        int i = userService.deleteByIdList(Arrays.asList(1, 2));
        log.info("删除 " + i);

    }

    @Test
    public void insertBatch() {
        User user1 = new User();
        user1.setUsername("xiaoxiao");
        user1.setTelephone("123");
        user1.setEmail("123@163.com");

        User user2 = new User();
        user2.setUsername("xiaoxiao2");
        user2.setTelephone("123");
        user2.setEmail("123@163.com");

        User user3 = new User();
        user3.setUsername("xiaoxiao3");
        user3.setTelephone("123");
        user3.setEmail("123@163.com");

        List<User> userArrayList = new ArrayList<>();
        userArrayList.add(user1);
        userArrayList.add(user2);
        userArrayList.add(user3);

        Integer num = userService.insertBatch(userArrayList);

        log.info("批量插入" + num);

    }

}