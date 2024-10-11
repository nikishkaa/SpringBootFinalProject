package org.example.springbootfinalproject.entity.stable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Entity(name = "StableAddress")
@Data
@Table(name = "stable_address")
public class StableAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "country", nullable = false, length = 56)
    private String country;

    @Column(name = "region", nullable = false, length = 56)
    private String region;

    @Column(name = "city", nullable = true, length = 56)
    private String city;

    @Column(name = "street", nullable = true, length = 56)
    private String street;

    @Column(name = "building", nullable = true, length = 56)
    private String building;

    @Column(name = "corpus", nullable = true, length = 56)
    private String corpus;

    @Column(name = "postcode", nullable = true, length = 20)
    private String postcode;

    @Column(name = "description", nullable = true, length = 256)
    private String description;


    @OneToMany(mappedBy = "address")
    private Set<Stable> stables;
}
