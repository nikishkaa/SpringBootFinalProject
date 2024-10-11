package org.example.springbootfinalproject.entity.announcement;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Entity
@Data
@Table(name = "announcement_photo")
public class AnnouncementPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "photo_order", nullable = false)
    private int photoOrder;

    @Column(name = "photo_url", nullable = false)
    private String photoUrl;


    @ManyToOne
    @JoinColumn(name = "horse_announcement_id", nullable = false)
    private HorseAnnouncement announcement;


    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;
}
