package event;


import entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EventService {
    EventRepository eventRepository;
    @Autowired
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public void createEvent(String name, Date date, String description){

        Event event = new Event(name, date, description);
        eventRepository.save(event);
    }
}
