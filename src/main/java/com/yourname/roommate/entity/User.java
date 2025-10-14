package com.yourname.roommate.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.management.relation.Role;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum  Role {
        USER,
        ADMIN
    }
}
