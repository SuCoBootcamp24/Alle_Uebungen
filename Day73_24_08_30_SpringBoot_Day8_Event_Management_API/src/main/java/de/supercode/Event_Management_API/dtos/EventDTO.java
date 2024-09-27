package de.supercode.Event_Management_API.dtos;

import de.supercode.Event_Management_API.entitys.Participant;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Data
public class EventDTO {

    private Long id;

    private String name;

    private LocalDate date;

    private String location;

    private int participantSize;




}
