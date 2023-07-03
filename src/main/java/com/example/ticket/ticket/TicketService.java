package com.example.ticket.ticket;

import com.example.ticket.ticket.entities.Account;
import com.example.ticket.ticket.entities.Event;
import com.example.ticket.ticket.entities.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAll();
    Ticket findById(Integer id);
    List<Ticket> findAllByCustomer_email(Integer userId);
    void addTicket(Integer ticketId, Integer userId);
    Account findAccountById(Integer id);
    List<Event> findAllEvents();
    List<Ticket> findAllTicketsByEventId(Integer eventId);
}
