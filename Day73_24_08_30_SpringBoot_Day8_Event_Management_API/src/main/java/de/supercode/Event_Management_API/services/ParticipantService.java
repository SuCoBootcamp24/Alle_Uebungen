package de.supercode.Event_Management_API.services;

import de.supercode.Event_Management_API.entitys.Participant;
import de.supercode.Event_Management_API.repositorys.ParticipantRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

    ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }


    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public void deleteParticipant(long id) {
        participantRepository.deleteById(id);
    }
}
