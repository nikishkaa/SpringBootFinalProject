package org.example.springbootfinalproject.entity.stable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "stable_contact_info")
public class StableContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "email", nullable = false, unique = true, length = 128)
    private String email;

    @Column(name = "phone_number", nullable = true, length = 20)
    private String phoneNumber;

    @Column(name = "description", nullable = true, length = 256)
    private String description;


    @OneToMany(mappedBy = "contactInfo")
    private Set<Stable> stables;
}
