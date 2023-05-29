package com.example.ticket.ticket;

import com.example.ticket.ticket.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    public List<Ticket> findAll()
    {
        return ticketRepository.findAllByOrderByIdAsc();
    }

    public Ticket findById(Integer id)
    {
        Optional<Ticket> result = ticketRepository.findById(id);

        Ticket ticket = null;
        if(result.isPresent())
        {
            ticket = result.get();
            return ticket;
        }
        else
        {
            throw new RuntimeException("Did not find account id - " + id);
        }
    }
}
