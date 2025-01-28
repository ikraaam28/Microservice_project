package com.esprit.microservice.gestion_candidat.Repository;

import com.esprit.microservice.gestion_candidat.entity.Candidat;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;

public interface CandidatRepository extends JpaRepository<Candidat, Integer> {
 //   @Query("select c from Candidat c where c.nom like :nom")
 // public Page<Candidat> candidatByNom(@Param("name") String nom, Pageable pageable);
}
