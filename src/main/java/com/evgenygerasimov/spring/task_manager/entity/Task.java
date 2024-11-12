package com.evgenygerasimov.spring.task_manager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@Entity
@AllArgsConstructor
@Table(name = "tasks")
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    @NotBlank(message = "The title is required!")
    private String title;
    @Column(name = "description")
    @NotBlank(message = "The description is required!")
    private String description;
    @Column(name = "status")
    private String status;
    @Column(name = "priority")
    private String priority;
    @Column(name = "author")
    private String author;
    @Column(name = "executor")
    private String executor;
    @Column(name = "comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    private transient Map<String, String> statuses;
    private transient Map<String, String> priorities;
    private transient List<User> listUsers;

    public Task() {
        statuses = new HashMap<>();
        statuses.put("done", "done");
        statuses.put("in progress", "in progress");
        statuses.put("not done", "not done");
        priorities = new HashMap<>();
        priorities.put("High", "High");
        priorities.put("Medium", "Medium");
        priorities.put("Low", "Low");
    }

    public Task(int i, String s, String s1, String done, String high, String ivan, String petr, String comment, User user) {
        this.id = i;
        this.title = s;
        this.description = s;
        this.status = s;
        this.priority = done;
        this.author = done;
        this.executor = done;
        this.comment = comment;
        this.user = user;
    }
}