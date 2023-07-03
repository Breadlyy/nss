package com.example.ticket.ticket.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;


    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;
    @Column(name = "bought")
    private boolean bought;
//    @Embedded
//    private Sector sector;

    @Column (name = "seat", nullable = false)
    private Integer seat;

    @Column(name = "ownerId")
    private Integer ownerId;




}
