package com.evgenygerasimov.spring.to_do.taskmanager2.controller;


import com.evgenygerasimov.spring.to_do.taskmanager2.entity.Role;
import com.evgenygerasimov.spring.to_do.taskmanager2.entity.User;
import com.evgenygerasimov.spring.to_do.taskmanager2.service.RoleService;
import com.evgenygerasimov.spring.to_do.taskmanager2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @RequestMapping("/")
    public String home() {
        return "registration-or-sign-in";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ModelAndView("redirect:/tasks/tasks");
        } catch (AuthenticationException ex) {
            return new ModelAndView("redirect:/login?error=true");
        }
    }

    @GetMapping("/allUsers")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.findAll());
        return "all-users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("userEntity") User user) {
        user.setPassword("{bcrypt}" + passwordEncoder.encode(user.getPassword()));
        Role role = new Role();
        role.setUsername(user.getUsername());
        role.setAuthority(user.getRole());
        userService.save(user);
        roleService.save(role);
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout() {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(null, null));
        return "redirect:/";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
