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
@Table(name = "medical_service", schema = "nuosdemo")
@NamedQueries({
        @NamedQuery(name = "MedicalService.findAll", query = "select m from MedicalService m"),
        @NamedQuery(name = "MedicalService.findByNameIgnoreCase", query = "select m from MedicalService m where upper(m.name) = upper(:name)")
})
public class MedicalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "name", length = 100, unique = true)
    private String name;

    @Column(name = "price")
    private Integer price;

    @OneToMany(mappedBy = "medicalService", orphanRemoval = true)
    private Set<Visit> visits = new LinkedHashSet<>();
}