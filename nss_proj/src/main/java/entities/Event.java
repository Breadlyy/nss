//package entities;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@Entity
//@Table(name = "event")
//public class Event {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
//    @SequenceGenerator(name = "event_seq")
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @ToString.Exclude
//    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
//    @JoinColumn(name = "client_id", nullable = false)
//    private Client client;
//
//    @Enumerated
//    @Column(name = "event_status", nullable = false)
//    private EventStatus eventStatus;
//
//    @ToString.Exclude
//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "event_places",
//            joinColumns = @JoinColumn(name = "event_id"),
//            inverseJoinColumns = @JoinColumn(name = "places_id"))
//    private Set<Place> places = new LinkedHashSet<>();
//
//    @OneToMany(mappedBy = "event", cascade = CascadeType.PERSIST, orphanRemoval = true)
//    private Set<Administrator.Ticket> tickets = new LinkedHashSet<>();
//
//}