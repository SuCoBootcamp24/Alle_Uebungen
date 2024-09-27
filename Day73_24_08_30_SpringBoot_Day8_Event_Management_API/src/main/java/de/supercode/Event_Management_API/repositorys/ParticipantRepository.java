package de.supercode.Event_Management_API.repositorys;

import de.supercode.Event_Management_API.entitys.Participant;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant,Long> {
}
