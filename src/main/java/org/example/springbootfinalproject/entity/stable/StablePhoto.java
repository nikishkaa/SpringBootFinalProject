package org.example.springbootfinalproject.entity.stable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Entity
@Data
@Table(name = "stable_photo")
public class StablePhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "photo_order", nullable = false)
    private int photoOrder;

    @Column(name = "photo_url", nullable = false)
    private String photoUrl;


    @ManyToOne
    @JoinColumn(name = "stable_id", nullable = false)
    private Stable stableId;


    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;
}
