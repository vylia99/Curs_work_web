package com.example.demo1711.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "client")
@NamedQueries({
        @NamedQuery(name = "Client.findAll", query = "select c from Client c")
})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @OneToMany(mappedBy = "client")
    private Set<Pet> pets = new LinkedHashSet<>();
}