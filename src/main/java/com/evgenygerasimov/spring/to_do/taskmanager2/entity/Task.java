package com.evgenygerasimov.spring.to_do.taskmanager2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@Entity
@AllArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
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
}