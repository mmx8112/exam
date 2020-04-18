package com.limai.exam.dao;

import com.limai.exam.entity.po.User;
import com.limai.exam.entity.qo.UserQO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author mahuahua
 * @date 2020/4/18 17:40
 */
@Mapper
public interface UserMapper {

    User findById(Integer id);

    List<User> findAll();

    int save(User user);

    int updateById(User user);

    int insertBatch(List<User> userList);

    int deleteById(int id);

    int deleteByIdList(List<Integer> idList);

    List<User> findByUserQO(UserQO userQO);


}
