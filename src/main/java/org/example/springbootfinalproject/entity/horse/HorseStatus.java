package org.example.springbootfinalproject.entity.horse;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "horse_status")
public class HorseStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "status_name", nullable = false, length = 128)
    private String name;

    @Column(name = "description", nullable = true, length = 256)
    private String description;


    @OneToMany(mappedBy = "status")
    private Set<Horse> horses;
}
