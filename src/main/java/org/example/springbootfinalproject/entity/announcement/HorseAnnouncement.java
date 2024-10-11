package org.example.springbootfinalproject.entity.announcement;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbootfinalproject.entity.horse.Horse;
import org.example.springbootfinalproject.entity.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "horse_announcements")
public class HorseAnnouncement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "heading", length = 128, nullable = false)
    private String heading;

    @Column(name = "description", length = 2048, nullable = true)
    private String description;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "views", nullable = false)
    private int views;


    @ManyToOne
    @JoinColumn(name = "horse_id", nullable = false)
    private Horse horse;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User sellerId;


    @OneToMany(mappedBy = "announcement")
    private Set<AnnouncementPhoto> announcementPhotos;


    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;

    @Column(name = "updated_ts", nullable = true)
    private Timestamp updatedTs;
}
