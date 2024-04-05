package com.example.ResponseEntity.mode;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private Long id;
    @NotEmpty(message = "name cannot empty")
    @NotNull
    private String name;
    @NotEmpty(message = "Email cannot empty")
    @Email(message = "this type email not supported")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Employee() {
    }
}
