package de.supercode.todo.entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "todo")
@Data
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    private String description;

    private boolean isDone;

    private int priority;


    @ManyToOne
    @JoinColumn(name = "list_id", nullable = false)
    private ToDoList todolist;

    public ToDo() {
    }

    public ToDo (String title, String description, int priority, ToDoList todolist) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.todolist = todolist;
        this.isDone = false;
    }

    //------ OTHER -------
}
