package de.supercode.Event_Management_API.controllers;

import de.supercode.Event_Management_API.dtos.EventDTO;
import de.supercode.Event_Management_API.entitys.Event;
import de.supercode.Event_Management_API.entitys.Participant;
import de.supercode.Event_Management_API.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event newEvent = eventService.createEvent(event);
        if (newEvent == null) return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getEvents() {
        List<Event> events = eventService.getEvents();
        if (events.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(events);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable Long eventId) {
        Optional<Event> event = eventService.findById(eventId);
        if (event.isEmpty()) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(event.get());
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long eventId, @RequestBody Event event) {
       Event updatedEvent = eventService.updateEvent(eventId, event);
        if (updatedEvent == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        if (eventService.deleteEvent(eventId)) return ResponseEntity.ok().build();
        else return ResponseEntity.notFound().build();
    }

    @PostMapping("/{eventId}/participants")
    public ResponseEntity<Event> addParticipantToEvent(@PathVariable Long eventId, @RequestBody Participant participant) {
        Event updatedEvent = eventService.addParticipantToEvent(eventId, participant);
        if (updatedEvent == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(updatedEvent);
    }

    @GetMapping("/{eventId}/participants")
    public ResponseEntity<List<Participant>> getParticipantsByEventId(@PathVariable Long eventId) {
        List<Participant> participants = eventService.getParticipantsByEventId(eventId);
        if (participants.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(participants);
    }

    @PutMapping("/{eventId}/participants/{participantId}")
    public ResponseEntity<Participant> updateParticipantInEvent(@PathVariable Long eventId, @PathVariable Long participantId, @RequestBody Participant participant) {
        Participant updatedParticipant = eventService.updateParticipantToEvent(eventId, participantId, participant);
        if (updatedParticipant == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(updatedParticipant);
    }

    @DeleteMapping("/{eventId}/participants/{participantId}")
    public ResponseEntity<Void> deleteParticipantFromEvent(@PathVariable Long eventId, @PathVariable Long participantId) {
        if (eventService.deleteParticipantFromEvent(eventId, participantId)) return ResponseEntity.ok().build();
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/counts")
    public ResponseEntity<List<EventDTO>> getSizeOfParticipantFromAllEvents() {
        List<EventDTO> eventCounts = eventService.getSizeOfParticipantFromAllEvents();
        if (eventCounts.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(eventCounts);
    }
}
