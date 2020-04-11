package com.limai.exam.service;

import com.limai.exam.entity.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    Integer save(User user);
    Integer updateById(User user);
    Integer insertBatch(List<User> userList);
    int deleteByIdList(List<Integer> idList);

}
