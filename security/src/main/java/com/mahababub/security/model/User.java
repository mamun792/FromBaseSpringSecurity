package com.mahababub.security.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(
        name = "users"
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    private  long id;
    private  String firstName;
    private  String lastName;
    private  String username;
    private  String password;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authorities_id")
    )
    private Set<Authority>  authorities;


}
