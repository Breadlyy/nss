package ticket.entities;


import lombok.*;

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

//    @Enumerated
//    @Column(name = "ticket_type", nullable = false)
//    private TicketType ticketType;

    @Column(name = "bought")
    private boolean bought;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;


    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

//    @Embedded
//    private Sector sector;

    @Column (name = "seat", nullable = false)
    private Integer seat;

    @Column(name = "number", nullable = false, unique = true)
    private Long number;

    @Column(name = "email")
    private String email;




}
