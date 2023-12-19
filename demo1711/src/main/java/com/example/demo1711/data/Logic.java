package com.example.demo1711.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "logic")
public class Logic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 100)
    @Column(name = "username", length = 100)
    private String username;
    @Size(max = 10)
    @Column(name = "password", length = 10)
    private String password;

}

