package de.supercode.todo.dto;

import de.supercode.todo.entity.ToDo;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ToDoListDTO {

    private Long id;

    private String title;

    private String description;

    private int toDosSize;

    public ToDoListDTO() {
    }



    //------ OTHER -------

}
