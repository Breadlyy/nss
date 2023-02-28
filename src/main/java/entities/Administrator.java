package entities;

import entitiesbase.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Administrator extends User {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @Entity
    @Table(name = "ticket")
    public static class Ticket {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(name = "id", nullable = false)
        private UUID id;

        @Embedded
        private Sector sector;

        @ToString.Exclude
        @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
        @JoinColumn(name = "customer_id", nullable = false)
        private Customer customer;

        @ToString.Exclude
        @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
        @JoinColumn(name = "event_id", nullable = false)
        private Event event;

    }
}