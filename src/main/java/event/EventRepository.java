package event;

import entities.Event;
import entities.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;


public interface EventRepository extends JpaRepository<Event, Integer> {

}
