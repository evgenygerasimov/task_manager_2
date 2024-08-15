package com.evgenygerasimov.spring.to_do.taskmanager2.controller;



import com.evgenygerasimov.spring.to_do.taskmanager2.entity.Task;
import com.evgenygerasimov.spring.to_do.taskmanager2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyTaskController {
    private final TaskService taskService;

    @Autowired
    public MyTaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/tasks")
    public String showAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "all-tasks";
    }
    @RequestMapping("/addNewTask")
    public String addNewTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "add-task";
    }
    @RequestMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.addTask(task);
        return "redirect:/tasks";
    }
    @RequestMapping("/updateTask")
    public String updateTask(@RequestParam("taskId") int id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "add-task";
    }
    @RequestMapping("/deleteTask")
    public String deleteTask(@RequestParam("taskId") int id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

}
