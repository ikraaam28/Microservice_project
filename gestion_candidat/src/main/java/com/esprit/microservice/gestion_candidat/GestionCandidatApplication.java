package com.esprit.microservice.gestion_candidat;

import com.esprit.microservice.gestion_candidat.Repository.CandidatRepository;
import com.esprit.microservice.gestion_candidat.entity.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GestionCandidatApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionCandidatApplication.class, args);
    }
    @Autowired
    private CandidatRepository repository;
    @Bean
    ApplicationRunner init() {
        return (args)-> {
            repository.save(new Candidat("Mariem", "Ch", "ma@esprit.tn"));
            repository.save(new Candidat("Sarra", "Ab", "sa@esprit.tn"));
            repository.save(new Candidat("Mohammed", "Ba", "mo@esprit.tn"));
            repository.save(new Candidat("Maroua", "Dh", "maroua@esprit.tn"));
            repository.findAll().forEach(System.out::println);

        };
    }
}
