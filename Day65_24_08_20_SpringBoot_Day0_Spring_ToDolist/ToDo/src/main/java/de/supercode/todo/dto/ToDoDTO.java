package de.supercode.todo.dto;

import de.supercode.todo.entity.ToDoList;
import lombok.Data;

@Data
public class ToDoDTO {

    private Long id;

    private String title;

    private String description;

    private boolean isDone;

    private int priority;

    private Long toDoListId;

    public ToDoDTO() {
    }

    public ToDoDTO (String title, String description, int priority, long id) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.id = id;
    }

    public ToDoDTO (String title, String description, int priority, Long toDoListId) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.toDoListId = toDoListId;
    }

    //------ OTHER -------

}
