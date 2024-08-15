package com.evgenygerasimov.spring.to_do.taskmanager2.controller;



import com.evgenygerasimov.spring.to_do.taskmanager2.entity.User;
import com.evgenygerasimov.spring.to_do.taskmanager2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyAuthController {
    private final UserService userService;

    public MyAuthController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/login")
    public String login (){
        return "login";
    }
    @RequestMapping("/")
    public String home() {
        return "registration-or-sign-in";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }
    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("task") User user) {
        userService.save(user);
        return "redirect:/tasks";
    }
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
}
