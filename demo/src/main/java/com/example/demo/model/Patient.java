package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String socialSecurityNumber;

    @Enumerated(EnumType.STRING)
    private PatientStatus status = PatientStatus.NORMAL;

    private int missedAppointmentsCount = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public PatientStatus getStatus() {
        return status;
    }

    public void setStatus(PatientStatus status) {
        this.status = status;
    }

    public int getMissedAppointmentsCount() {
        return missedAppointmentsCount;
    }

    public void setMissedAppointmentsCount(int missedAppointmentsCount) {
        this.missedAppointmentsCount = missedAppointmentsCount;
    }
}
