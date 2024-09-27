package de.supercode.todo.service;

import de.supercode.todo.component.ToDoListMapper;
import de.supercode.todo.component.ToDoMapper;
import de.supercode.todo.dto.ToDoDTO;
import de.supercode.todo.dto.ToDoListDTO;
import de.supercode.todo.entity.ToDo;
import de.supercode.todo.entity.ToDoList;
import de.supercode.todo.repository.ToDoListRepository;
import de.supercode.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository toDoRepository;

    @Autowired
    ToDoListRepository toDoListRepository;

    @Autowired
    ToDoMapper toDoMapper;

    @Autowired
    ToDoListMapper toDoListMapper;


    public List<ToDoDTO> getAllTasks(Long listID) {
        List<ToDo> toDoListOpt = toDoRepository.findAllByTodolistId(listID);

        if (!toDoListOpt.isEmpty()) {
            return toDoListOpt.stream().map(toDo -> {
                ToDoDTO dto = new ToDoDTO();
                dto.setId(toDo.getId());
                dto.setTitle(toDo.getTitle());
                dto.setDescription(toDo.getDescription());
                dto.setDone(toDo.isDone());
                dto.setPriority(toDo.getPriority());
                dto.setToDoListId(toDo.getTodolist().getId());
                return dto;
            }).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }


    public List<ToDoDTO> getAllToDosInListThatNotDone(ToDoListDTO toDoListDTO) {
        List<ToDo> todosNotDone = toDoRepository.findAllByTodolistIdAndIsDone(toDoListDTO.getId(), false);

        return todosNotDone.stream().map(todo -> {
            ToDoDTO dto = new ToDoDTO();
            dto.setId(todo.getId());
            dto.setTitle(todo.getTitle());
            dto.setDescription(todo.getDescription());
            dto.setDone(todo.isDone());
            dto.setPriority(todo.getPriority());
            dto.setToDoListId(todo.getTodolist().getId());
            return dto;
        }).collect(Collectors.toList());
    }

    public Optional<ToDoDTO> getTask(Long taskId) {
        Optional<ToDo> task = toDoRepository.findById(taskId);
        return task.map(t -> {
            ToDoDTO dto = new ToDoDTO();
            dto.setId(t.getId());
            dto.setTitle(t.getTitle());
            dto.setDescription(t.getDescription());
            dto.setDone(t.isDone());
            dto.setPriority(t.getPriority());
            dto.setToDoListId(t.getTodolist().getId());
            return dto;
        });
    }


    public void CreateNewTask(ToDoListDTO toDoListDTO, ToDoDTO newToDoDTO) {
        Optional<ToDoList> existListOpt = toDoListRepository.findById(newToDoDTO.getToDoListId());
        if (existListOpt.isPresent()) {
            ToDo newToDo = new ToDo(newToDoDTO.getTitle(), newToDoDTO.getDescription(), newToDoDTO.getPriority(), existListOpt.get());
            toDoRepository.save(newToDo);
        }

    }

    public boolean UpdateTask(ToDoDTO updatedToDoDTO) {
        Optional<ToDo> existTask = toDoRepository.findById(updatedToDoDTO.getId());
        if (existTask.isPresent()) {
            ToDo updatedTask = existTask.get();
            updatedTask.setTitle(updatedToDoDTO.getTitle());
            updatedTask.setDescription(updatedToDoDTO.getDescription());
            updatedTask.setPriority(updatedToDoDTO.getPriority());
            updatedTask.setDone(updatedToDoDTO.isDone());
            toDoRepository.save(updatedTask);
            return true;
        }
        return false;
    }

    public ToDoDTO findTask(Long taskId) {
        Optional<ToDo> existToDo = toDoRepository.findById(taskId);
        if (existToDo.isPresent()) {
            return toDoMapper.toDTO(existToDo.get());
        }
        return null;
    }

    public void deleteTask(ToDoDTO toDoDTO) {
        toDoRepository.delete(toDoMapper.toEntity(toDoDTO));
    }
}
