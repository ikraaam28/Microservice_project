package com.esprit.microservice.job.Controller;


import com.esprit.microservice.job.Services.JobService;
import com.esprit.microservice.job.entity.Job;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // Afficher tous les jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    // Afficher un job par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Integer id) {
        Optional<Job> job = jobService.getJobById(id);
        return job.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Afficher un job par son nom
    @GetMapping("/name/{name}")
    public ResponseEntity<Job> getJobByName(@PathVariable String name) {
        Optional<Job> job = jobService.getJobByName(name);
        return job.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Modifier l'état du job
    @PutMapping("/{id}/status")
    public ResponseEntity<Job> updateJobStatus(@PathVariable Integer id, @RequestParam boolean isAvailable) {
        Job updatedJob = jobService.updateJobStatus(id, isAvailable);
        if (updatedJob != null) {
            return ResponseEntity.ok(updatedJob);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}