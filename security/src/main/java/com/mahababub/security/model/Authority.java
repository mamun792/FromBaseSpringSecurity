package com.mahababub.security.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(
        name = "authorities"
)

public class Authority {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String authority;
}
