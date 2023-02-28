package entities;

import entitiesbase.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class PlaceModerator extends User {
    @OneToMany(mappedBy = "placeModerator", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<Place> places = new LinkedHashSet<>();

}