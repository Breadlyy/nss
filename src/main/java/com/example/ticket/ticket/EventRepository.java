package com.example.ticket.ticket;

import com.example.ticket.ticket.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JpaRepository is an interface of Spring Data JPA framework
 * JpaRepository extends another interface - CrudRepository
 */
public interface EventRepository extends JpaRepository<Event, Integer> {
    /**
     * Find all by id list.
     *
     * @param id the id
     * @return the list
     */
    List<Event> findAllById(Integer id);
}
