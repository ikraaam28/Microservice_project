package com.esprit.microservice.job.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "T_Job")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "service")
    private String service;
    private boolean etat;  // true = disponible, false = occupé


    public void setEtat(boolean etat) {
        this.etat = etat;
    }
}
