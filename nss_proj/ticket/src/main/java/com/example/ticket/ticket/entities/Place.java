package com.example.ticket.ticket.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "place")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Place {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
}
