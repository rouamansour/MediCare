package com.example.demo.controller;

import com.example.demo.model.Patient;
import com.example.demo.service.ConsultationService;
import com.example.demo.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;
    private final ConsultationService consultationService;

    public PatientController(PatientService patientService, ConsultationService consultationService) {
        this.patientService = patientService;
        this.consultationService = consultationService;
    }

    @PostMapping
    public Patient createPatient(@RequestBody CreatePatientRequest request) {
        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setSocialSecurityNumber(request.getSocialSecurityNumber());
        return patientService.create(patient);
    }

    @GetMapping("/{id}/history")
    public List<?> getPatientHistory(@PathVariable Long id) {
        return consultationService.getHistoryForPatient(id);
    }

    public static class CreatePatientRequest {
        private String name;
        private String socialSecurityNumber;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSocialSecurityNumber() {
            return socialSecurityNumber;
        }

        public void setSocialSecurityNumber(String socialSecurityNumber) {
            this.socialSecurityNumber = socialSecurityNumber;
        }
    }
}
