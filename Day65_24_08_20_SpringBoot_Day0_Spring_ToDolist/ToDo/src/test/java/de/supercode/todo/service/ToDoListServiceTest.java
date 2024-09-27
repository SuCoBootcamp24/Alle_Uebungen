package de.supercode.todo.service;

import de.supercode.todo.dto.ToDoListDTO;
import de.supercode.todo.entity.ToDoList;
import de.supercode.todo.repository.ToDoListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ToDoListServiceTest {

    @InjectMocks
    private ToDoListService toDoListService;

    @Mock
    private ToDoListRepository toDoListRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateToDoList() {
        long listId = 1L;
        String title = "Test List";
        String description = "Test List description";

        ToDoList mockToDoList = new ToDoList();
        mockToDoList.setId(listId);
        mockToDoList.setTitle(title);
        mockToDoList.setDescription(description);

        ToDoListDTO toDoListDTO = new ToDoListDTO();
        toDoListDTO.setId(listId);
        toDoListDTO.setTitle(title);
        toDoListDTO.setDescription(description);

        when(toDoListRepository.save(any(ToDoList.class))).thenAnswer(invocation -> {
            ToDoList savedToDoList = invocation.getArgument(0);
            savedToDoList.setId(listId);
            return savedToDoList;
        });

        Long result = toDoListService.createNewList(toDoListDTO);

        assertNotNull(result);
        assertEquals(listId, result);
    }
}