package de.supercode.Event_Management_API.services;

import de.supercode.Event_Management_API.dtos.EventDTO;
import de.supercode.Event_Management_API.entitys.Event;
import de.supercode.Event_Management_API.entitys.Participant;
import de.supercode.Event_Management_API.repositorys.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    EventRepository eventRepository;

    ParticipantService participantService;

    public EventService(EventRepository eventRepository, ParticipantService participantService) {
        this.eventRepository = eventRepository;
        this.participantService = participantService;
    }

    public Event createEvent(Event event) {
        if (eventRepository.findByName(event.getName()).isPresent()) return null;
        return eventRepository.save(event);
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }


    public Event updateEvent(Long eventId, Event event) {
        return eventRepository.findById(eventId).map(existEvent -> {
                updateNonNullFields(event, existEvent);
                return eventRepository.save(existEvent);
                })
                .orElse(null);
    }

    private void updateNonNullFields(Event updateEvent, Event event) {
        if (updateEvent.getName()!= null) event.setName(updateEvent.getName());
        if (updateEvent.getDate()!= null) event.setDate(updateEvent.getDate());
        if (updateEvent.getLocation()!= null) event.setLocation(updateEvent.getLocation());
    }

    public boolean deleteEvent(Long eventId) {
        return eventRepository.findById(eventId).map(event -> {
            eventRepository.delete(event);
            return true;
        }).orElse(false);
    }

    public Event addParticipantToEvent(Long eventId, Participant participant) {
        return eventRepository.findById(eventId).map(event -> {
            event.addParticipant(participantService.createParticipant(participant));
            return eventRepository.save(event);
        }).orElse(null);
    }

    public List<Participant> getParticipantsByEventId(Long eventId) {
        return eventRepository.findById(eventId).map(Event::getParticipantList).orElse(null);
    }

    public Participant updateParticipantToEvent(Long eventId, Long participantId, Participant participant) {
        Optional<Event> existEvent = eventRepository.findById(eventId);
        if (existEvent.isPresent()) {
            Optional<Participant> existingParticipant = existEvent.get().getParticipantList().stream()
                    .filter(participant1 -> participant1.getId() == participantId)
                    .findFirst();
            if (existingParticipant.isPresent()) {
                existingParticipant.get().setName(participant.getName());
                existingParticipant.get().setEmail(participant.getEmail());
                existingParticipant.get().setConfirmed(participant.isConfirmed());
                eventRepository.save(existEvent.get());
                return existingParticipant.get();
            }

        }
        return null;
    }

    @Transactional
    public boolean deleteParticipantFromEvent(Long eventId, Long participantId) {
        Optional<Event> existEvent = eventRepository.findById(eventId);
        if (existEvent.isPresent()) {
            Event event = existEvent.get();
            Optional<Participant> existingParticipant = event.getParticipantList().stream()
                    .filter(participant -> participant.getId() == participantId)
                    .findFirst();
            if (existingParticipant.isPresent()) {
                Participant participant = existingParticipant.get();
                event.getParticipantList().remove(participant); // Entferne aus der Liste
                eventRepository.save(event); // Speichere das Event ohne den Teilnehmer

                participantService.deleteParticipant(participantId); // Lösche den Teilnehmer aus der DB

                return true;
            }
        }
        return false;
    }

    public List<EventDTO> getSizeOfParticipantFromAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> {
            EventDTO eventDTO = new EventDTO();
            eventDTO.setId(event.getId());
            eventDTO.setName(event.getName());
            eventDTO.setDate(event.getDate());
            eventDTO.setLocation(event.getLocation());
            eventDTO.setParticipantSize(event.getParticipantList() != null ? event.getParticipantList().size() : 0);
            return eventDTO;
        }).collect(Collectors.toList());
    }
}
