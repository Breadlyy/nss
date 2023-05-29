package com.example.ticket.ticket.entities;



import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Enumerated
    @Column(name = "ticket_type", nullable = false)
    private TicketType ticketType;


    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;


    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    @Embedded
    private Sector sector;

    @Column (name = "seat", nullable = false)
    private Integer seat;

    @Column(name = "number", nullable = false, unique = true)
    private Long number;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ticket ticket = (Ticket) o;
        return getId() != null && Objects.equals(getId(), ticket.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
