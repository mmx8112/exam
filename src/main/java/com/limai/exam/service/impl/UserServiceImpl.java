package com.limai.exam.service.impl;

import com.limai.exam.dao.UserMapper;
import com.limai.exam.entity.User;
import com.limai.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userMapper.findAll();
        return userList;
    }

    @Override
    public Integer save(User user) {
        userMapper.save(user);
        return user.getId();
    }

    @Override
    public Integer updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public Integer insertBatch(List<User> userList) {
        return userMapper.insertBatch(userList);
    }

    @Override
    public int deleteByIdList(List<Integer> idList) {
        return userMapper.deleteByIdList(idList);
    }
}
