//package entities;
//
//import entitiesbase.User;
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
//public class Client extends User {
//    @Enumerated(EnumType.STRING)
//    @Column(name = "client_type", nullable = false)
//    private ClientType clientType;
//
//    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST, orphanRemoval = true)
//    private Set<Event> events = new LinkedHashSet<>();
//
//}