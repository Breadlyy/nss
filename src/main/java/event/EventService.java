package event;


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

    public void createEvent(String name, String description, Date date){
        eventRepository.createEvent(name, description, date);
    }
}
