package de.supercode.todo.service;

import de.supercode.todo.dto.ToDoDTO;
import de.supercode.todo.entity.ToDo;
import de.supercode.todo.entity.ToDoList;
import de.supercode.todo.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class ToDoServiceTest {

    @InjectMocks
    private ToDoService toDoService;

    @Mock
    private ToDoRepository toDoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetToDoById() {
        // Create a mock ToDoList object
        ToDoList mockToDoList = new ToDoList();
        mockToDoList.setId(1L);
        mockToDoList.setTitle("Test ToDo List");

        // Create a mock ToDo object and set the ToDoList
        ToDo mockToDo = new ToDo();
        mockToDo.setId(1L);
        mockToDo.setTitle("Test ToDo");
        mockToDo.setTodolist(mockToDoList); // Set the ToDoList object

        // Mock the repository to return the mock ToDo object
        when(toDoRepository.findById(anyLong())).thenReturn(Optional.of(mockToDo));

        // Call the service method
        Optional<ToDoDTO> result = toDoService.getTask(1L);

        // Assert that the result is not null and has the expected title
        assertNotNull(result);
        assertEquals("Test ToDo", result.get().getTitle());
    }


    @Test
    void testGetToDoByIdNotFound() {
        when(toDoRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<ToDoDTO> result = toDoService.getTask(1L);

        assertTrue(result.isEmpty());
    }
}