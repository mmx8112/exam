package com.limai.exam.controller;

import com.limai.exam.entity.dto.UserAnswer;
import com.limai.exam.entity.po.User;
import com.limai.exam.service.UserService;
import com.limai.exam.uitl.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mahuahua
 * @date 2020/4/18 17:40
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResultData findById(@RequestParam Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResultData.fail(0, "用户不存在");
        }
        return ResultData.success(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResultData save(@RequestBody User user) {
        try {
            Integer save = userService.save(user);
            return ResultData.success(user);
        } catch (Exception e) {
            log.error("dsfa", e);
        }
        return ResultData.fail(0, "异常");
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ResultData submit(@RequestBody UserAnswer userAnswer) {
        int score = userService.submit(userAnswer);
        Map result = new HashMap();
        result.put("score", score);
        return ResultData.success(result);
    }
}
