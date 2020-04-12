package com.limai.exam.controller;

import com.limai.exam.entity.User;
import com.limai.exam.service.UserService;
import com.limai.exam.uitl.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
