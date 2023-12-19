package com.example.demo1711.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NamedQueries({
        @NamedQuery(name = "Visit.findAll", query = "select v from Visit v")
})
@Getter
@Setter
public class Visit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private LocalDateTime dateTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @ManyToOne(optional = false)
    @JoinColumn(name = "medical_service_id", nullable = false)
    private MedicalService medicalService;

}
