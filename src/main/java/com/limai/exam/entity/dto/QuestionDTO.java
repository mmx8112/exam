package com.limai.exam.entity.dto;

import com.limai.exam.entity.po.QuestionOption;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author mhh
 * @date 2020/4/18 19:43
 */
@Data
public class QuestionDTO implements Serializable {
    private Integer id;

    private Integer positionType;

    private Integer questionType;

    private String description;

    private Integer rightAnswer;

    private Integer deleted;

    private List<QuestionOption>  options;


}
