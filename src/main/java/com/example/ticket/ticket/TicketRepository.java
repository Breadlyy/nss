package com.example.ticket.ticket;

import com.example.ticket.ticket.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findAllByOrderByIdAsc();
    List<Ticket> findAllByOwnerId(Integer id);
    List<Ticket> findAllByEvent_Id(Integer eventId);
}

