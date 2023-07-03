package com.example.ticket.ticket;

import com.example.ticket.ticket.entities.Account;
import com.example.ticket.ticket.entities.Event;
import com.example.ticket.ticket.entities.Ticket;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/")
public class TicketController {

    TicketService ticketService;
    SessionRepository sessionRepository;

    public TicketController(TicketService ticketService, SessionRepository sessionRepository) {
        this.ticketService = ticketService;
        this.sessionRepository = sessionRepository;
    }

    @GetMapping("/")
    public String Tickets(Model model, @RequestParam("userId") Integer userId, HttpSession session)
    {
        session.setAttribute("userId", userId);
        return "redirect:/allEvents";
    }
    @PostMapping("/allTickets")
    public String allTickets(Model model, @RequestParam("eventId") Integer eventId)
    {
        List<Ticket> tickets = ticketService.findAllTicketsByEventId(eventId);

        model.addAttribute("tickets", tickets);

       // sessionRepository.saveSession(session.getId(), String.valueOf(userId));
        return "allTickets";
    }
    @GetMapping("/yourTickets")
    public String yourTickets(Model model, HttpSession session)
    {
        Integer userId = (Integer) session.getAttribute("userId");
        Account account = ticketService.findAccountById(userId);
        List<Ticket> tickets = ticketService.findAllByCustomer_email(userId);
        model.addAttribute("tickets", tickets);
        return "yourTickets";
    }

    @PostMapping("/addTicket")
    public String addTicket(@RequestParam("id") Integer id, HttpSession session)
    {
        Ticket ticket = ticketService.findById(id);
//        String uid = (String) session.getAttribute("userId");
//        Integer userId = Integer.valueOf(uid);
        Integer userId = (Integer) session.getAttribute("userId");
        ticketService.addTicket(id,userId);
        return "redirect:/yourTickets";
    }
    @GetMapping("/allEvents")
    public String allEvents(Model model)
    {
        List<Event> events = ticketService.findAllEvents();
        model.addAttribute("events", events);
        return "allEvents";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        String sessionId = session.getId();
        session.invalidate(); // Инвалидируем сессию
        sessionRepository.deleteSession(sessionId); // Удаляем сессию из базы данных
        return "redirect:signInForm";
    }
    @GetMapping("/currentUser")
    public void user(HttpSession session, HttpServletResponse response) throws IOException {
        String username = sessionRepository.getUsernameBySessionId(session.getId());
        response.getWriter().write(username);
    }
    @GetMapping("/currentSession")
    public void session(HttpSession session, HttpServletResponse response) throws IOException {
        response.getWriter().write(session.getId());
    }
}
