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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/todolist")
public class ToDoListController {


    @Autowired
    ToDoListService toDoListService;

    @Autowired
    ToDoService toDoService;


    @GetMapping(value = "")
    public ResponseEntity<List<ToDoListDTO>> getAllLists() {
        List<ToDoListDTO> list = toDoListService.getAllLists();

        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(value = "/get_todos")
    public ResponseEntity<List<ToDoDTO>> getAllToDosInList(@RequestParam String listID) {
        ToDoListDTO existToDoList = toDoListService.findExistingToDoListByID(Long.parseLong(listID));

        if (existToDoList != null) {
           List<ToDoDTO> toDoList = toDoService.getAllTasks(existToDoList.getId());
           if (!toDoList.isEmpty()) return new ResponseEntity<>(toDoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/notDone")
    public ResponseEntity<List<ToDoDTO>> getAllNotDoneToDosInList(@RequestParam String listID) {
        ToDoListDTO existToDoList = toDoListService.findExistingToDoListByID(Long.parseLong(listID));

        if (existToDoList != null) {
            List<ToDoDTO> toDosInListNotDone = toDoService.getAllToDosInListThatNotDone(existToDoList);
            if (!toDosInListNotDone.isEmpty()) {
                return new ResponseEntity<>(toDosInListNotDone, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<Long> createNewList(@RequestBody ToDoListDTO newToDoListDTO) {
        long newId = toDoListService.createNewList(newToDoListDTO);

        if (newId >= -1) return new ResponseEntity<>(newId, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> deleteList(@RequestParam String listID) {

        if (toDoListService.deleteList(Long.parseLong(listID)) == true) return new ResponseEntity<>(true, HttpStatus.OK);
        else return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

    }

}
