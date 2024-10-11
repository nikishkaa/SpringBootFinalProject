package org.example.springbootfinalproject.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Setter
@Table(name = "user_address")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "country", nullable = false, length = 56)
    private String country;

    @Column(name = "region", nullable = false, length = 56)
    private String region;


    @OneToMany(mappedBy = "address")
    private Set<User> users;
}
