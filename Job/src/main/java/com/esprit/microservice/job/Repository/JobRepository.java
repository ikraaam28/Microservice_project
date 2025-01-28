package com.esprit.microservice.job.Repository;
import com.esprit.microservice.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Integer> {

    Optional<Job> findByService(String service); }