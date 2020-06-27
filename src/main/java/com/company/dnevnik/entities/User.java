package com.company.dnevnik.entities;

import com.company.dnevnik.controllers.MainController;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    @Column(name = "login", unique = true)
    String login;

    @NotNull
    @Column(name = "password")
    String password;

    @NotNull
    @Column(name = "is_active")
    int isActive;
}
