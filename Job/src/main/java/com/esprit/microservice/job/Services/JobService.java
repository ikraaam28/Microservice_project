package com.esprit.microservice.job.Services;

import com.esprit.microservice.job.Repository.JobRepository;
import com.esprit.microservice.job.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> getJobById(Integer id) {
        return jobRepository.findById(id);
    }

    public Optional<Job> getJobByName(String name) {
        return jobRepository.findByService(name);
    }

    public Job updateJobStatus(Integer id, boolean isAvailable) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            job.get().setEtat(isAvailable);
            return jobRepository.save(job.get());
        }
        return null;
    }
}