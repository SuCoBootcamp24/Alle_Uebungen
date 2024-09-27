package de.supercode.todo.component;

import de.supercode.todo.dto.ToDoDTO;
import de.supercode.todo.entity.ToDo;
import de.supercode.todo.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ToDoMapper {

    @Autowired
    ToDoListService toDoListService;

    @Autowired
    ToDoListMapper toDoListMapper;

    public ToDoDTO toDTO(ToDo toDo) {
        ToDoDTO dto = new ToDoDTO();
        dto.setId(toDo.getId());
        dto.setTitle(toDo.getTitle());
        dto.setDescription(toDo.getDescription());
        dto.setDone(toDo.isDone());
        dto.setPriority(toDo.getPriority());
        dto.setToDoListId(toDo.getTodolist().getId());
        return dto;
    }

    public ToDo toEntity(ToDoDTO dto) {
        ToDo toDo = new ToDo();
        toDo.setId(dto.getId());
        toDo.setTitle(dto.getTitle());
        toDo.setDescription(dto.getDescription());
        toDo.setDone(dto.isDone());
        toDo.setPriority(dto.getPriority());
        toDo.setTodolist(toDoListMapper.toEntity(toDoListService.findExistingToDoListByID(dto.getToDoListId())));
        return toDo;
    }
}
