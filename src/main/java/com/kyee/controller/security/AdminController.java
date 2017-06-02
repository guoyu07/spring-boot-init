package com.kyee.controller.security;

import com.kyee.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @GetMapping
    public ModelAndView list(Model model){
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "zhong", 20));
        users.add(new User(2L, "ding", 30));
        model.addAttribute("title", "管理员管理");
        model.addAttribute("userList", users);
        return new ModelAndView("user/list", "userModel", model);
    }
}
