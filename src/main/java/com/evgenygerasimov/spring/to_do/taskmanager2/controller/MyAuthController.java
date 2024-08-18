package com.evgenygerasimov.spring.to_do.taskmanager2.controller;



import com.evgenygerasimov.spring.to_do.taskmanager2.entity.User;
import com.evgenygerasimov.spring.to_do.taskmanager2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyAuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MyAuthController(UserService userService, AuthenticationManager authenticationManager, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;

        this.passwordEncoder = passwordEncoder;
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
        return "redirect:/";
    }

    @PostMapping("/auth")
    public String auth(@ModelAttribute("user") User user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        if(!userDetails.isAccountNonExpired()){
            return "redirect:/login";
        }
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        return "redirect:/about";

    }
    @RequestMapping("/logout")
    public String logout() {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(null, null));
        return "redirect:/";
    }

//    @PreAuthorize("hasRole('USER')")
    @GetMapping("/about")
    public String about() {
        return "about";
    }
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
}
