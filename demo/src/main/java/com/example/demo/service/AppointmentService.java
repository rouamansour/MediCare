package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.exception.AppointmentConflictException;
import com.example.demo.service.exception.PatientBlockedException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository,
                              PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public Appointment scheduleAppointment(Long patientId, Long doctorId, LocalDateTime startTime) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with id " + patientId));

        if (patient.getStatus() == PatientStatus.A_SURVEILLER) {
            throw new PatientBlockedException("Patient is blocked and cannot book online");
        }

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found with id " + doctorId));

        // Rule 1: control slot availability (30 min slot assumption)
        List<AppointmentStatus> blockingStatuses = List.of(AppointmentStatus.SCHEDULED);
        appointmentRepository.findByDoctorAndStartTimeAndStatusIn(doctor, startTime, blockingStatuses)
                .ifPresent(existing -> {
                    throw new AppointmentConflictException("Doctor already has an appointment at this time");
                });

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setStartTime(startTime);
        appointment.setStatus(AppointmentStatus.SCHEDULED);

        return appointmentRepository.save(appointment);
    }

    public void cancelAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found with id " + appointmentId));

        appointment.setStatus(AppointmentStatus.CANCELLED);
        appointmentRepository.save(appointment);
    }
}
