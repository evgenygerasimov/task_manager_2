package com.evgenygerasimov.spring.to_do.taskmanager2.entity;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name_task")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;
    @Column(name = "priority")
    private String priority;
    @Column(name = "author")
    private String author;

    private transient Map<String, String> statuses;
    private transient Map<String, String> priorities;

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

    public Task(int id, String name, String description, String status, String priority, String author, Map<String, String> statuses, Map<String, String> priorities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.author = author;
        this.statuses = statuses;
        this.priorities = priorities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Map<String, String> getStatuses() {
        return statuses;
    }

    public void setStatuses(Map<String, String> statuses) {
        this.statuses = statuses;
    }

    public Map<String, String> getPriorities() {
        return priorities;
    }

    public void setPriorities(Map<String, String> priorities) {
        this.priorities = priorities;
    }
}