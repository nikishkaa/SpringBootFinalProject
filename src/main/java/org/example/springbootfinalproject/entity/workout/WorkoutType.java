package org.example.springbootfinalproject.entity.workout;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "workout_type")
public class WorkoutType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "type_name", length = 128, nullable = false)
    private String name;

    @Column(name = "description", length = 512, nullable = true)
    private String description;


    @OneToMany(mappedBy = "workoutType")
    private Set<Workout> workouts;
}
