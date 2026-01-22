package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.ConsultationRepository;
import com.example.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConsultationService {

    private final ConsultationRepository consultationRepository;
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    public ConsultationService(ConsultationRepository consultationRepository,
                               AppointmentRepository appointmentRepository,
                               PatientRepository patientRepository) {
        this.consultationRepository = consultationRepository;
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    public java.util.List<Consultation> getHistoryForPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with id " + patientId));
        return consultationRepository.findByPatientOrderByIdDesc(patient);
    }

    public Consultation validateConsultation(Long appointmentId, VisitType visitType, String notes) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found with id " + appointmentId));

        Doctor doctor = appointment.getDoctor();
        Patient patient = appointment.getPatient();

        Consultation consultation = new Consultation();
        consultation.setAppointment(appointment);
        consultation.setDoctor(doctor);
        consultation.setPatient(patient);
        consultation.setVisitType(visitType);
        consultation.setNotes(notes);
        consultation.setFeeAmount(calculateFee(doctor.getSpecialty(), visitType));

        // mark appointment as done
        appointment.setStatus(AppointmentStatus.DONE);
        appointmentRepository.save(appointment);

        return consultationRepository.save(consultation);
    }

    private BigDecimal calculateFee(Specialty specialty, VisitType visitType) {
        BigDecimal base;
        switch (specialty) {
            case PEDIATRE -> base = BigDecimal.valueOf(30);
            case CARDIOLOGUE -> base = BigDecimal.valueOf(40);
            case GENERALISTE -> base = BigDecimal.valueOf(25);
            default -> base = BigDecimal.valueOf(25);
        }

        return switch (visitType) {
            case URGENCE -> base.multiply(BigDecimal.valueOf(1.5));
            case CONTROLE -> base.multiply(BigDecimal.valueOf(0.8));
            case STANDARD -> base;
        };
    }
}
