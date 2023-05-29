package com.example.ticket.ticket;

import com.example.ticket.ticket.entities.Ticket;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class TicketController {

    TicketService ticketService;

    List<Ticket> tickets = new ArrayList<>();

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/")
    public String allTickets(Model model)
    {
        List<Ticket> tickets = ticketService.findAll();
        model.addAttribute("tickets", tickets);

        return "ticket/allTickets";
    }
    @GetMapping("/yourTickets")
    public String yourTickets(Model model)
    {

        model.addAttribute("tickets", this.tickets);
        return "ticket/yourTickets";
    }

    @PostMapping("/addTicket")
    public String addTicket(@RequestParam("id") Integer id)
    {
        Ticket ticket = ticketService.findById(id);
        this.tickets.add(ticket);
        return "redirect:/yourTickets";
    }

}
