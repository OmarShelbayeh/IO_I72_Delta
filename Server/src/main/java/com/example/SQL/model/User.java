package com.example.SQL.model;

import lombok.*;

import javax.persistence.*;

//User model
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name="users")
public class User {
    @Id
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String password;
    private String role;
}