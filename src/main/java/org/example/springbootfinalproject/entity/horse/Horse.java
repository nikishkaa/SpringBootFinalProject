package org.example.springbootfinalproject.entity.horse;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbootfinalproject.entity.announcement.HorseAnnouncement;
import org.example.springbootfinalproject.entity.stable.Stable;
import org.example.springbootfinalproject.entity.user.User;
import org.example.springbootfinalproject.entity.workout.Workout;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "horses")
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", length = 128, nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Date age;

    @Column(name = "horse_breed", length = 128, nullable = true)
    private String horseBreed;


    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private HorseStatus status;

    @ManyToOne
    @JoinColumn(name = "user_owner_id", nullable = false)
    private User horseUserOwner;

    @ManyToOne
    @JoinColumn(name = "stable_owner_id", nullable = false)
    private Stable horseStableOwner;


    @OneToMany(mappedBy = "horseId")
    private Set<HorsePhoto> horsePhotoSet;

    @OneToMany(mappedBy = "horse")
    private Set<Workout> workouts;

    @OneToMany(mappedBy = "horse")
    private Set<HorseAnnouncement> announcements;


    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;

    @Column(name = "updated_ts")
    private Timestamp updatedTs;
}
