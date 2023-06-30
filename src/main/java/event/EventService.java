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

    public void createEvent(Event event){

        Event ev = new Event();
        ev.setName(event.getName());
        ev.setDate(event.getDate());
        ev.setDescription(event.getDescription());
        ev.setStatus("Active");
        eventRepository.save(ev);
    }
}
