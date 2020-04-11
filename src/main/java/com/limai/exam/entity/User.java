package com.limai.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mahuahua
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 4118526915029830557L;

    private Integer id;

    private String username;

    private String telephone;

    private String email;

    private Integer score;
    /**
     * 测试是否通过
     */
    private Integer passed;

    private Integer accept;

    /**
     * 是否删除状态
     * 默认1 否则0
     */
    private Integer deleted;

    private Date createTime;

    private Date updateTime;


}
