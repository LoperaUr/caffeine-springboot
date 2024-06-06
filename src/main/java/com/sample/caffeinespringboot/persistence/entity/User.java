package com.sample.caffeinespringboot.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private String email;

    @Column(name = "password_encoded")
    private String password;

    @Column(name = "password_decoded")
    private String passwordDecoded;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}