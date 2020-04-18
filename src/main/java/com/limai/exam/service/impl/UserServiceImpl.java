package com.limai.exam.service.impl;

import com.limai.exam.dao.UserMapper;
import com.limai.exam.entity.dto.Answer;
import com.limai.exam.entity.dto.UserAnswer;
import com.limai.exam.entity.po.Question;
import com.limai.exam.entity.po.User;
import com.limai.exam.entity.qo.UserQO;
import com.limai.exam.service.QuestionSerivce;
import com.limai.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author mahuahua
 * @date 2020/4/18 17:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionSerivce questionSerivce;


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

    @Override
    public List<User> findByUserQO(UserQO userQO) {
        List<User> userList = userMapper.findByUserQO(userQO);
        if (CollectionUtils.isEmpty(userList)) {
            return new ArrayList<>();
        }
        return userList;

    }

    @Override
    public int submit(UserAnswer userAnswer) {
        List<Answer> answers = userAnswer.getAnswers();
        if (CollectionUtils.isEmpty(answers)) {
            return 0;
        }
        List<Integer> questionIdList = answers.stream()
                .map(Answer::getQuestionId)
                .collect(Collectors.toList());

        List<Question> questionList = questionSerivce.findByIdList(questionIdList);
//        Map<Integer, Integer> questionIdAnswerMap = new HashMap<>();
//        for(Question question : questionList){
//            questionIdAnswerMap.put(question.getId(),question.getRightAnswer());
//        }

        Map<Integer, Integer> questionIdAnswerMap = questionList.stream().collect(Collectors.toMap(Question::getId, Question::getRightAnswer));

        int rightNum = 0;
        for (Answer answer : answers) {
            if (answer.getUserQuestionAnswer().equals(questionIdAnswerMap.get(answer.getQuestionId()))) {
                rightNum++;
            }
        }

//        int rows = userMapper.updateScore(rightNum * 10, userAnswer.getUseId());

        return rightNum * 10;
    }
}
