package de.supercode.todo.repository;

import de.supercode.todo.entity.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    Iterable<ToDo> findAllByisDone(boolean isDone);

    List<ToDo> findAllByTodolistId(Long toDoListId);

    List<ToDo> findAllByTodolistIdAndIsDone(Long toDoListId, boolean isDone);
}
