package com.limai.exam.service;

import com.limai.exam.entity.dto.UserAnswer;
import com.limai.exam.entity.po.User;
import com.limai.exam.entity.qo.UserQO;

import java.util.List;

/**
 *
 * @author mahuahua
 * @date 2020/4/18 17:40
 */
public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    Integer save(User user);

    Integer updateById(User user);

    Integer insertBatch(List<User> userList);

    int deleteByIdList(List<Integer> idList);

    List<User> findByUserQO(UserQO userQO);

    int submit(UserAnswer userAnswer);
}
