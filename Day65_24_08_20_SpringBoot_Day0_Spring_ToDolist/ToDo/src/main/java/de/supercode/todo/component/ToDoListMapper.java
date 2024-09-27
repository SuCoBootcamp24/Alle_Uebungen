package de.supercode.todo.component;

import de.supercode.todo.dto.ToDoListDTO;
import de.supercode.todo.entity.ToDoList;
import org.springframework.stereotype.Component;

@Component
public class ToDoListMapper {

    public ToDoListDTO toDTO(ToDoList toDoList) {
        ToDoListDTO dto = new ToDoListDTO();
        dto.setId(toDoList.getId());
        dto.setTitle(toDoList.getTitle());
        dto.setDescription(toDoList.getDescription());
        dto.setToDosSize(toDoList.getToDosSize());
        return dto;
    }

    public ToDoList toEntity(ToDoListDTO dto) {
        ToDoList toDoList = new ToDoList();
        toDoList.setId(dto.getId());
        toDoList.setTitle(dto.getTitle());
        toDoList.setDescription(dto.getDescription());
        toDoList.setToDosSize(toDoList.getToDosSize());
        return toDoList;
    }
}
