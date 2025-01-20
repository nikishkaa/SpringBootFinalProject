package org.example.springbootfinalproject.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbootfinalproject.entity.announcement.HorseAnnouncement;
import org.example.springbootfinalproject.entity.horse.Horse;
import org.example.springbootfinalproject.entity.stable.Stable;
import org.example.springbootfinalproject.entity.stable.StableReview;
import org.example.springbootfinalproject.entity.workout.Workout;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", length = 128, nullable = false)
    private String username;

    @Column(name = "email", unique = true, length = 128, nullable = false)
    private String email;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    @Column(name = "phone_number", length = 20, nullable = true)
    private String phoneNumber;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "address", nullable = true)
    private UserAddress address;


    @OneToMany(mappedBy = "userOwner")
    private Set<Stable> stables;

    @OneToMany(mappedBy = "horseUserOwner")
    private Set<Horse> horse;

    @OneToMany(mappedBy = "userId")
    private Set<UserPhoto> userId;

    @OneToMany(mappedBy = "userId")
    private Set<StableReview> reviews;

    @OneToMany(mappedBy = "client")
    private Set<Workout> client;

    @OneToMany(mappedBy = "coach")
    private Set<Workout> coach;

    @OneToMany(mappedBy = "sellerId")
    private Set<HorseAnnouncement> announcements;


    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;


    @Column(name = "updated_ts", nullable = true)
    private Timestamp updatedTs;

    public User(String username, String password, String email, String phoneNumber) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
