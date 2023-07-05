package com.example.ticket.ticket;

import com.example.ticket.ticket.entities.Account;
import com.example.ticket.ticket.entities.Event;
import com.example.ticket.ticket.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Ticket service imp.
 */
@Service
public class TicketServiceImp implements TicketService{
    /**
     * The Ticket repository.
     */
    TicketRepository ticketRepository;
    /**
     * The Account repository.
     */
    AccountRepository accountRepository;
    /**
     * The Event repository.
     */
    EventRepository eventRepository;

    /**
     * Instantiates a new Ticket service imp.
     *
     * @param ticketRepository  the ticket repository
     * @param accountRepository the account repository
     * @param eventRepository   the event repository
     */
    @Autowired
    public TicketServiceImp(TicketRepository ticketRepository, AccountRepository accountRepository, EventRepository eventRepository) {
        this.ticketRepository = ticketRepository;
        this.accountRepository = accountRepository;
        this.eventRepository = eventRepository;
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAllByOrderByIdAsc();
    }

    /**
     *
     * @param id
     * @return ticket in accordance with id
     */
    public Ticket findById(Integer id) {
        Optional<Ticket> result = ticketRepository.findById(id);

        Ticket ticket = null;
        if (result.isPresent()) {
            ticket = result.get();
            return ticket;
        } else {
            throw new RuntimeException("Did not find account id - " + id);
        }
    }

    public List<Ticket> findAllByCustomer_email(Integer userId) {
        return ticketRepository.findAllByOwnerId(userId);
    }

    /**
     * add ticket to the user's "Available tickets" section
     * @param ticketId
     * @param userId
     */
    public void addTicket(Integer ticketId, Integer userId) {
        Optional<Account> result = accountRepository.findById(userId);

        Account account = null;
        if(result.isPresent())
        {
            account = result.get();
        }
        else
        {
            throw new RuntimeException("Did not find account id - " + userId);
        }
        Optional<Ticket> t = ticketRepository.findById(ticketId);

        Ticket ticket = null;
        if(t.isPresent())
        {
            ticket = t.get();
        }
        else
        {
            throw new RuntimeException("Did not find ticket id - " + ticketId);
        }
            ticket.setOwnerId(userId);
            ticketRepository.save(ticket);

            account.setTicket(ticketId);
            accountRepository.save(account);
    }

    public Account findAccountById(Integer id)
    {
        Optional<Account> result = accountRepository.findById(id);

        Account account = null;
        if(result.isPresent())
        {
            account = result.get();
        }
        else
        {
            throw new RuntimeException("Did not find account id - " + id);
        }
        return account;
    }
    @Cacheable("allEvents")
    public List<Event> findAllEvents()
    {
        return eventRepository.findAll();
    }
    public List<Ticket> findAllTicketsByEventId(Integer eventId)
    {
        return ticketRepository.findAllByEvent(eventId);
    }
}
