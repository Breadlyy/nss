package ticket.entities;

import lombok.*;

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
}
