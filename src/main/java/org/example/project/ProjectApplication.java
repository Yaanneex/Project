package org.example.project;

import org.example.project.entities.Patient;
import org.example.project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;


    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



        Patient patient3 = Patient.builder().nom("samir").dateNaissance(new Date()).malade(true).score(2).build();


        patientRepository.save(patient3);
        patientRepository.save(new Patient(null,"Jawad",new Date(),true,55));
        patientRepository.save(new Patient(null,"Adil",new Date(),true,33));
        patientRepository.save(new Patient(null,"iK",new Date(),false,22));

    }
}
