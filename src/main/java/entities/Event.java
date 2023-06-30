package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import entities.EventStatus;


import java.util.Date;

@Entity
@Table(name = "event")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Event {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name="date")
    private Date date;
    @Column(name="status")
    private EventStatus status;
    @Column(name = "description")
    private String description;
    public Event(String name, Date date, String description) {
        this.name = name;
        this.date = date;
        this.status = EventStatus.Active;
        this.description = description;
    }
}
