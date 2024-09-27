package de.supercode.todo.service;

import de.supercode.todo.component.ToDoListMapper;
import de.supercode.todo.dto.ToDoDTO;
import de.supercode.todo.dto.ToDoListDTO;
import de.supercode.todo.entity.ToDoList;
import de.supercode.todo.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoListService {

    @Autowired
    ToDoListRepository toDoListRepository;

    @Autowired
    ToDoListMapper toDoListMapper;

    public long createNewList(ToDoListDTO newToDoListDTO) {
        ToDoList newList = new ToDoList(newToDoListDTO.getTitle(), newToDoListDTO.getDescription());
        toDoListRepository.save(newList);
        return newList.getId();
    }


    public List<ToDoListDTO> getAllLists() {

        List<ToDoList> lists = (List<ToDoList>) toDoListRepository.findAll();
        return lists.stream().map(list -> {
            ToDoListDTO dto = new ToDoListDTO();
            dto.setId(list.getId());
            dto.setTitle(list.getTitle());
            dto.setDescription(list.getDescription());
            dto.setToDosSize(list.getToDosSize());
            return dto;
        }).collect(Collectors.toList());
    }

    public ToDoListDTO findExistingToDoListByID(long listID) {
        Optional<ToDoList> toDoList = toDoListRepository.findById(listID);
        if (toDoList.isPresent()) {
            return toDoListMapper.toDTO(toDoList.get());
        }
        return null;
    }

    public boolean deleteList(Long listId) {
        Optional<ToDoList> toDoList = toDoListRepository.findById(listId);
        if (toDoList.isPresent()) {
            toDoListRepository.delete(toDoList.get());
            return true;
        }
        return false;
    }

    public void updateTasksSize(long listId, int n) {
        Optional<ToDoList> existListOpt = toDoListRepository.findById(listId);
        if (existListOpt.isPresent()) {
            ToDoList existList = existListOpt.get();
            existList.setToDosSize(existList.getToDosSize() + n);
            toDoListRepository.save(existList);
        }
    }

}
