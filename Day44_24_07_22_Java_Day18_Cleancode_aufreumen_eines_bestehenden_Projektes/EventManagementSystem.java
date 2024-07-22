import java.util.*;

class EventManagementSystem {
    private final List<Event> EVENT_LIST = new ArrayList<>();
    private final List<Participant> PARTICIPANT_LIST = new ArrayList<>();



    public List<Event> getEVENT_LIST() {
        return EVENT_LIST;
    }


    public List<Participant> getPARTICIPANT_LIST() {
        return PARTICIPANT_LIST;
    }


    //-----

    public void addEvent(String name, Date date, String location, int maxParticipants) {
        if (findExistEvent(name).isEmpty()) {
            Event event = new Event(name, date, location, maxParticipants);
            getEVENT_LIST().add(event);
        }
    }


    public void removeEvent(String name) {
        getEVENT_LIST().removeIf(event -> event.getName().equals(name));
    }


    public void addParticipant(String firstName, String lastName, String email) {
        if (findExistParticipant(email).isEmpty()) {
            Participant participant = new Participant(firstName, lastName, email);
            getPARTICIPANT_LIST().add(participant);
        } else System.out.println("Teilnehmer bereits vorhanden");

    }



    public void removeParticipant(String email) {
        getPARTICIPANT_LIST().removeIf(participant -> participant.getEmail().equals(email));
    }


    public void registerParticipantToEvent(String eventName, String participantEmail) {
        Optional<Event> existEvent = findExistEvent(eventName);

        Optional<Participant> existParticipant = findExistParticipant(participantEmail);

        if (existEvent.isEmpty() || existParticipant.isEmpty()) {
            System.out.println("Veranstaltung oder Teilnehmer nicht gefunden");
            return;
        } else {
            Event event = existEvent.get();
            Participant participant = existParticipant.get();
            if (event.getParticipants().size() < event.getMaxParticipants()) {
                event.getParticipants().add(participant);
            } else {
                System.out.println("Maximale Teilnehmerzahl erreicht");
            }
        }
    }

    private Optional<Participant> findExistParticipant(String participantEmail) {
        return getPARTICIPANT_LIST().stream()
                .filter(p -> p.getEmail().equals(participantEmail))
                .findFirst();
    }

    private Optional<Event> findExistEvent(String eventName) {
        return getEVENT_LIST().stream()
                .filter(e -> e.getName().equals(eventName))
                .findFirst();
    }

    public void unregisterParticipantFromEvent(String eventName, String participantEmail) {
        Optional<Event> existEvent = findExistEvent(eventName);
        Optional<Participant> existParticipant = findExistParticipant(participantEmail);

        if (existEvent.isPresent() && existParticipant.isPresent()) {
            Event event = existEvent.get();
            event.getParticipants().removeIf(p -> p.getEmail().equals(participantEmail));
        }
    }


    public void displayEvents() {
        for (Event event : getEVENT_LIST()) {
            System.out.println("Event: " + event.getName() + ", Ort: " + event.getLocation());
            displayParticipants(event);
        }
    }

    public void displayParticipants() {
        for (Participant participant : getPARTICIPANT_LIST()) {
            System.out.println("Teilnehmer: " + participant.getFirstName() + " " + participant.getLastName() + ", E-Mail: " + participant.getEmail());
        }
    }

    public void displayParticipants(Event event) {
        for (Participant participant : event.getParticipants()) {
            System.out.println("Teilnehmer: " + participant.getFirstName() + " " + participant.getLastName() + ", E-Mail: " + participant.getEmail());
        }
    }
}
