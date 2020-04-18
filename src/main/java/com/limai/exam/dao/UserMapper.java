package com.limai.exam.dao;

import com.limai.exam.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User findById(Integer id);

    List<User> findAll();

    int save(User user);

    int updateById(User user);

    int insertBatch(List<User> userList);

    int deleteById(int id);

    int deleteByIdList(List<Integer> idList);


}
