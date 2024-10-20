package org.example.springbootfinalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app-users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // @Column(unique = true)
    private String username;
    private String password;


    public AppUser(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

}