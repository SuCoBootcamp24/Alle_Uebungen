package de.supercode.todo.repository;

import de.supercode.todo.entity.ToDoList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToDoListRepository extends CrudRepository<ToDoList, Long> {


}
