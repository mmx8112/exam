package com.limai.exam.service.impl;

import com.limai.exam.dao.QuestionOptionMapper;
import com.limai.exam.dao.QuestionMapper;
import com.limai.exam.entity.dto.QuestionDTO;
import com.limai.exam.entity.po.QuestionOption;
import com.limai.exam.entity.po.Question;
import com.limai.exam.entity.qo.QuestionQO;
import com.limai.exam.service.QuestionSerivce;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author mahuahua
 * @date 2020/4/18 17:40
 */
@Service
public class QuestionSerivceImpl implements QuestionSerivce {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionOptionMapper optionMapper;

    @Override
    public List<Question> findByIdList(List<Integer> idList) {
        List<Question> questionList = questionMapper.findByIdList(idList);
        return questionList;
    }

    @Override
    public List<QuestionDTO> findQuestionDTO(QuestionQO questionQO) {
        List<Question> questionList = questionMapper.findByQuestionQO(questionQO);
        List<Integer> questionIdList = questionList.stream().map(Question::getId).collect(Collectors.toList());
        List<QuestionOption> optionList = optionMapper.findByQuestionIdList(questionIdList);
        Map<Integer, List<QuestionOption>> questionIdOptionMap = optionList.stream().collect(Collectors.groupingBy(QuestionOption::getQuestionId));

        List<QuestionDTO> list = new ArrayList<>(questionList.size());
        for (Question question : questionList) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setOptions(questionIdOptionMap.get(question.getId()));
            list.add(questionDTO);
        }
        return list;
    }
}
