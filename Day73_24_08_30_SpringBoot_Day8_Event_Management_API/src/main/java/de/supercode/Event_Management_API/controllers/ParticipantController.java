package de.supercode.Event_Management_API.controllers;

import de.supercode.Event_Management_API.entitys.Participant;
import de.supercode.Event_Management_API.services.ParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/events/participant")
public class ParticipantController {

    ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }



}
