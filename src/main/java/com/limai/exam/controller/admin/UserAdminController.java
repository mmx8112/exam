package com.limai.exam.controller.admin;

import com.limai.exam.entity.User;
import com.limai.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/user-admin")
public class UserAdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String findALL(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("list", userList);
        return "/userList";
    }

}
