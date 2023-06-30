package event;

import entities.EventStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class EventRepository {
    private final JdbcTemplate jdbcTemplate;

    public EventRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public void createEvent(String name, String description, Date date){
        jdbcTemplate.update("INSERT INTO event (name, description, date, status) VALUES (?,?,?,?)", name, description, date, EventStatus.Active);
    }
}
