package ticket.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class Sector {
    @Column(name = "type")
    private String type;

    @Column(name = "place", nullable = false, unique = true)
    private Integer place;

    @Column(name = "name", nullable = false)
    private String name;
    @Id
    private Long id;


}