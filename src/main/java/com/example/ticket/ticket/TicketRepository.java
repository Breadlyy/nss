package com.example.ticket.ticket;

import com.example.ticket.ticket.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JpaRepository is an interface of Spring Data JPA framework
 * JpaRepository extends another interface - CrudRepository
 */
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    /**
     * Find all by order by id asc list.
     *
     * @return the list
     */
    List<Ticket> findAllByOrderByIdAsc();

    /**
     * Find all by owner id list.
     *
     * @param id the id
     * @return the list
     */
    List<Ticket> findAllByOwnerId(Integer id);

    /**
     * Find all by event list.
     *
     * @param eventId the event id
     * @return the list
     */
    List<Ticket> findAllByEvent(Integer eventId);
}

