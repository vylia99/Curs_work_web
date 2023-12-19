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
@Table(name = "pet")
@NamedQueries({
        @NamedQuery(name = "Pet.findAll", query = "select p from Pet p"),
        @NamedQuery(name = "Pet.findByNameIgnoreCase", query = "select p from Pet p where upper(p.kind) = upper(:kind)")
})
public class Pet {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "age", length = 10)
    private Integer age;

    @Column(name = "kind", length = 10)
    private String kind;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "pet", orphanRemoval = true)
    private Set<Visit> visits = new LinkedHashSet<>();
}