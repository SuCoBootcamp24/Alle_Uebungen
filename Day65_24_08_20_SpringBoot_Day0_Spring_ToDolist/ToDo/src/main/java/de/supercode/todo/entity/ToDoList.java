package de.supercode.todo.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "todolist")
@Data
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;


    private int toDosSize;


    public ToDoList() {
    }

    public ToDoList(String title, String description) {
        this.title = title;
        this.description = description;
        this.toDosSize = 0;
    }

    //------ OTHER -------
}
