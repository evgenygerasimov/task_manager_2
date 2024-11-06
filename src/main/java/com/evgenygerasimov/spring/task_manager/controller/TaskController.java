package com.evgenygerasimov.spring.task_manager.controller;

import com.evgenygerasimov.spring.task_manager.entity.Task;
import com.evgenygerasimov.spring.task_manager.entity.User;
import com.evgenygerasimov.spring.task_manager.service.TaskService;
import com.evgenygerasimov.spring.task_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/tasks")
    public String showAllTasks(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
            model.addAttribute("tasks", user.getTasks());
        } else if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_EXECUTOR"))) {
            model.addAttribute("tasks", taskService.findAllByExecutor(user));
        }
        return "all-tasks";
    }

    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    @GetMapping("/addNewTask")
    public String addNewTask(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Task task = new Task();
        task.setAuthor(authentication.getName());
        task.setListUsers(userService.getListExecutors());
        task.setUser(userService.findByUsername(authentication.getName()));
        model.addAttribute("task", task);
        return "add-task";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.addTask(task);
        return "redirect:/tasks/tasks";
    }

    @GetMapping("/updateTask")
    public String updateTask(@RequestParam("taskId") int id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Task task = taskService.getTaskById(id);
        task.setListUsers(userService.getListExecutors());
        model.addAttribute("task", task);
        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
            return "add-task";
        } else
            return "update-task-for-executor";
    }

    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    @GetMapping("/deleteTask")
    public String deleteTask(@RequestParam("taskId") int id) {
        taskService.deleteTask(id);
        return "redirect:/tasks/tasks";
    }


    @GetMapping("/userTasks")
    public String showUserTasks(@RequestParam("userName") String username, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(username);
        if (user.getUsername().equals(auth.getName())) {
            if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
                model.addAttribute("tasks", user.getTasks());
            } else if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_EXECUTOR"))) {
                model.addAttribute("tasks", taskService.findAllByExecutor(user));
            }
            return "all-tasks";
        } else if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
            model.addAttribute("tasks", user.getTasks());
        } else if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_EXECUTOR"))) {
            model.addAttribute("tasks", taskService.findAllByExecutor(user));
        }
        return "all-tasks-for-read";
    }
}
