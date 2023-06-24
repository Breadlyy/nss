package com.example.ticket.ticket;

import com.example.ticket.ticket.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findAllById(Integer id);
}
