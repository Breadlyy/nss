package com.example.ticket.ticket.entities;


import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Entity
@Table(name = "event")
@Getter
@Setter
@AllArgsConstructor
public class Event {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private String date;

    public Event(Integer id, String name, String date, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.status = "Active";
        this.description = description;
    }

    public Event(String name, String date, String description) {
        this.name = name;
        this.date = date;
        this.status = "Active";
        this.description = description;
    }
    public Event()
    {

    }
}
