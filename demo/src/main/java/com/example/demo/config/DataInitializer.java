package com.example.demo.config;

import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.PatientStatus;
import com.example.demo.model.Specialty;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadData(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        return args -> {
            if (doctorRepository.count() == 0) {
                Doctor d1 = new Doctor();
                d1.setName("Dr. Dupont");
                d1.setSpecialty(Specialty.GENERALISTE);

                Doctor d2 = new Doctor();
                d2.setName("Dr. Martin");
                d2.setSpecialty(Specialty.CARDIOLOGUE);

                doctorRepository.save(d1);
                doctorRepository.save(d2);
            }

            if (patientRepository.count() == 0) {
                Patient p1 = new Patient();
                p1.setName("Jean Patient");
                p1.setSocialSecurityNumber("1234567890123");
                p1.setStatus(PatientStatus.NORMAL);

                Patient p2 = new Patient();
                p2.setName("Marie Test");
                p2.setSocialSecurityNumber("9876543210987");
                p2.setStatus(PatientStatus.NORMAL);

                patientRepository.save(p1);
                patientRepository.save(p2);
            }
        };
    }
}
