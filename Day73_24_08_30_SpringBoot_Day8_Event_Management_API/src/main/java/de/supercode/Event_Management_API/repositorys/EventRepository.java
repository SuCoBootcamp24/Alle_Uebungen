package de.supercode.Event_Management_API.repositorys;


import de.supercode.Event_Management_API.entitys.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByName(String name);
}
