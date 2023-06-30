package event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/")
public class EventController {

    private final EventService eventService;
    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }
    @GetMapping("/eventForm")
    public String showForm(Model model) {
        model.addAttribute("formData", new FormData());
        return "create-event";
    }

    @PostMapping("/createEvent")
    public String createEvent(FormData formData) {
        if (formData.isValid()) {
            // Call your function here
            eventService.createEvent(formData.getEventName(), formData.getDateField(), formData.getEventDescription());
            // You can perform any necessary operations with the form data
            // and return the appropriate view or redirect to another page
            return "home-screen";
        } else {
            return "create-event";
        }
    }


    public static class FormData {
        private String eventName;
        private String eventDescription;
        private String ticketNumber;
        private Date dateField;

        // getters and setters

        public String getEventName() {
            return eventName;
        }

        public String getEventDescription() {
            return eventDescription;
        }

        public String getTicketNumber() {
            return ticketNumber;
        }

        public Date getDateField() {
            return dateField;
        }

        public boolean isValid() {
            if (eventName == null || eventName.isEmpty()
                    || eventDescription == null || eventDescription.isEmpty()
                    || ticketNumber == null || ticketNumber.isEmpty()
                    || dateField == null) {
                return false;
            }

            try {
                Integer.parseInt(ticketNumber);
            } catch (NumberFormatException e) {
                return false; // textField3 is not a valid number
            }

            return true;
        }
    }
}
