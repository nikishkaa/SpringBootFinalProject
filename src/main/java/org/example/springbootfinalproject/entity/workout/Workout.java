package org.example.springbootfinalproject.entity.workout;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbootfinalproject.entity.horse.Horse;
import org.example.springbootfinalproject.entity.stable.Stable;
import org.example.springbootfinalproject.entity.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@Entity
@Data
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "date_time", nullable = false)
    private Date date;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "currency", nullable = false)
    private String currency;


    @ManyToOne
    @JoinColumn(name = "workout_type_id", nullable = false)
    private WorkoutType workoutType;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private User client;

    @ManyToOne
    @JoinColumn(name = "stable_id", nullable = false)
    private Stable stable;

    @ManyToOne
    @JoinColumn(name = "horse_id", nullable = false)
    private Horse horse;

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    private User coach;


    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;

    @Column(name = "updated_ts", nullable = true)
    private Timestamp updatedTs;
}
