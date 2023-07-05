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


/**
 * The type Ticket controller.
 */
@Controller
@RequestMapping("/")
public class TicketController {

    /**
     * The Ticket service imp.
     */
    TicketServiceImp ticketServiceImp;
    /**
     * The Session repository.
     */
    SessionRepository sessionRepository;

    /**
     * Instantiates a new Ticket controller.
     *
     * @param ticketServiceImp  the ticket service imp
     * @param sessionRepository the session repository
     */
    public TicketController(TicketServiceImp ticketServiceImp, SessionRepository sessionRepository) {
        this.ticketServiceImp = ticketServiceImp;
        this.sessionRepository = sessionRepository;
    }

    /**
     * Tickets string.
     *
     * @param model   the model
     * @param userId  get from "Account" microservice
     * @param session leveraged to save user's ud
     * @return redirect to the "allEvents" page
     */
    @GetMapping("/")
    public String Tickets(Model model, @RequestParam("userId") Integer userId, HttpSession session)
    {
        session.setAttribute("userId", userId);
        return "redirect:/allEvents";
    }

    /**
     * All tickets string.
     *
     * @param model   the model
     * @param eventId the event id
     * @return display event's tickets
     */
    @PostMapping("/allTickets")
    public String allTickets(Model model, @RequestParam("eventId") Integer eventId)
    {
        List<Ticket> tickets = ticketServiceImp.findAllTicketsByEventId(eventId);

        model.addAttribute("tickets", tickets);

       // sessionRepository.saveSession(session.getId(), String.valueOf(userId));
        return "allTickets";
    }

    /**
     * Your tickets string.
     *
     * @param model   the model
     * @param session leveraged to obtain user's id and then find his tickets
     * @return user 's tickets
     */
    @GetMapping("/yourTickets")
    public String yourTickets(Model model, HttpSession session)
    {
        Integer userId = (Integer) session.getAttribute("userId");
        Account account = ticketServiceImp.findAccountById(userId);
        List<Ticket> tickets = ticketServiceImp.findAllByCustomer_email(userId);
        model.addAttribute("tickets", tickets);
        model.addAttribute("account", account);
        return "yourTickets";
    }

    /**
     * Add ticket string.
     *
     * @param id      the id
     * @param session the session
     * @return add ticket's to user's "Available tickets" section
     */
    @PostMapping("/addTicket")
    public String addTicket(@RequestParam("id") Integer id, HttpSession session)
    {
        Ticket ticket = ticketServiceImp.findById(id);
//        String uid = (String) session.getAttribute("userId");
//        Integer userId = Integer.valueOf(uid);
        Integer userId = (Integer) session.getAttribute("userId");
        ticketServiceImp.addTicket(id,userId);
        return "redirect:/yourTickets";
    }

    /**
     * All events string.
     *
     * @param model the model
     * @return show all events
     */
    @GetMapping("/allEvents")
    public String allEvents(Model model)
    {
        List<Event> events = ticketServiceImp.findAllEvents();
        model.addAttribute("events", events);
        return "allEvents";
    }

    /**
     * Logout string.
     *
     * @param session the session
     * @return user 's logout
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        String sessionId = session.getId();
        session.invalidate(); // Инвалидируем сессию
        sessionRepository.deleteSession(sessionId); // Удаляем сессию из базы данных
        return "redirect:signInForm";
    }
//    @GetMapping("/currentUser")
//    public void user(HttpSession session, HttpServletResponse response) throws IOException {
//        String username = sessionRepository.getUsernameBySessionId(session.getId());
//        response.getWriter().write(username);
//    }
//    @GetMapping("/currentSession")
//    public void session(HttpSession session, HttpServletResponse response) throws IOException {
//        response.getWriter().write(session.getId());
//    }
}
