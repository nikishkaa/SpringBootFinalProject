package org.example.springbootfinalproject.entity.stable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbootfinalproject.entity.horse.Horse;
import org.example.springbootfinalproject.entity.user.User;
import org.example.springbootfinalproject.entity.workout.Workout;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "stables")
public class Stable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", length = 128, nullable = false)
    private String name;

    @Column(name = "horses_capacity", nullable = false)
    private int horseCapacity;


    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User userOwner;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private StableAddress address;

    @ManyToOne
    @JoinColumn(name = "stable_contact_info_id", nullable = true)
    private StableContactInfo contactInfo;


    @OneToMany(mappedBy = "horseStableOwner")
    private Set<Horse> horseId;

    @OneToMany(mappedBy = "stableId")
    private Set<StablePhoto> stablePhotos;

    @OneToMany(mappedBy = "stableId")
    private Set<StableReview> reviews;

    @OneToMany(mappedBy = "stable")
    private Set<Workout> workouts;


    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;

    @Column(name = "updated_ts")
    private Timestamp updatedTs;
}
