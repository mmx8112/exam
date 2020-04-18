package com.limai.exam.controller.admin;

import com.limai.exam.entity.po.User;
import com.limai.exam.entity.qo.UserQO;
import com.limai.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * @author mahuahua
 * @date 2020/4/18 17:40
 */
@Controller
@RequestMapping("/user-admin")
public class UserAdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String findALL(UserQO userQO, Model model) {
        List<User> userList = userService.findByUserQO(userQO);
        model.addAttribute("userList", userList);
        return "user_list";
    }

    
}
