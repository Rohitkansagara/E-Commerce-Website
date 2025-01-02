package com.a99.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Custom getter (optional) for Role name
    // Store role name, for example: "ROLE_USER", "ROLE_ADMIN"
    @Getter
    @Column(name = "role_name", nullable = false)
    private String name;

    // Constructor (optional, based on your use case)
    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

}
