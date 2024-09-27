package de.supercode.todo.controller;

import de.supercode.todo.dto.ToDoDTO;
import de.supercode.todo.dto.ToDoListDTO;
import de.supercode.todo.entity.ToDo;
import de.supercode.todo.entity.ToDoList;
import de.supercode.todo.service.ToDoListService;
import de.supercode.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/todolist/task")
public class ToDoController {


    @Autowired
    ToDoService toDoService;

    @Autowired
    ToDoListService toDoListService;


    @GetMapping(value ="/get_todo")
    public ResponseEntity<ToDoDTO> getTask(@RequestParam String taskId) {
        Optional<ToDoDTO> existTask = toDoService.getTask(Long.parseLong(taskId));
        if (existTask.isPresent()) return new ResponseEntity<>(existTask.get(), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/add_todo")
    public ResponseEntity<Boolean> addTask(@RequestBody ToDoDTO newToDoDTO) {
        ToDoListDTO existList = toDoListService.findExistingToDoListByID(newToDoDTO.getToDoListId());

        if (existList != null) {
            toDoService.CreateNewTask(existList, newToDoDTO);
            toDoListService.updateTasksSize(existList.getId(), 1);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else return new ResponseEntity<>(false, HttpStatus.CONFLICT);
    }


    @PutMapping(value = "/update_todo")
    public ResponseEntity<Boolean> updateTask(@RequestBody ToDoDTO updatedToDoDTO) {
        if (toDoService.UpdateTask(updatedToDoDTO) == true) return new ResponseEntity<>(true, HttpStatus.OK);
        else return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/delete_todo")
    public ResponseEntity<Boolean> deleteTask(@RequestParam String taskId) {
        ToDoDTO existTask = toDoService.findTask(Long.parseLong(taskId));

        if (existTask != null) {

            toDoListService.updateTasksSize(existTask.getToDoListId(), -1);
            toDoService.deleteTask(existTask);

            return new ResponseEntity<>(true, HttpStatus.OK);
        } else return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }


}
