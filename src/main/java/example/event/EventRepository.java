package example.event;

import example.entities.EventStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class EventRepository {
    private final JdbcTemplate jdbcTemplate;

    public EventRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public void createEvent(String name, Date date){
        jdbcTemplate.update("INSERT INTO events (name, date, status) VALUES (?,?,?)", name, date, EventStatus.Active);
    }
}
