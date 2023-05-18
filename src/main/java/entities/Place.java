package entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "place")
public class Place {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Embedded
    private Sector sector;

    @Enumerated(EnumType.STRING)
    @Column(name = "place_type", nullable = false)
    private PlaceType placeType;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "place_moderator_id", nullable = false)
    private PlaceModerator placeModerator;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "places", cascade = CascadeType.PERSIST)
    private Set<Event> events = new LinkedHashSet<>();

    @OneToMany(mappedBy = "place", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<Ticket> tickets = new LinkedHashSet<>();

}