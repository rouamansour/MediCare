package com.example.demo.repository;

import com.example.demo.model.Appointment;
import com.example.demo.model.AppointmentStatus;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByDoctorAndStartTimeAndStatusIn(Doctor doctor,
                                                              LocalDateTime startTime,
                                                              List<AppointmentStatus> statuses);

    List<Appointment> findByPatientAndStartTimeBeforeAndStatusIn(Patient patient,
                                                                 LocalDateTime before,
                                                                 List<AppointmentStatus> statuses);
}
