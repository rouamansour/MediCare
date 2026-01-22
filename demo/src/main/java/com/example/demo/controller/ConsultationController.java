package com.example.demo.controller;

import com.example.demo.model.Consultation;
import com.example.demo.model.VisitType;
import com.example.demo.service.ConsultationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {

    private final ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @PostMapping
    public Consultation createConsultation(@RequestBody CreateConsultationRequest request) {
        VisitType visitType = VisitType.valueOf(request.getVisitType());
        return consultationService.validateConsultation(request.getAppointmentId(), visitType, request.getNotes());
    }

    public static class CreateConsultationRequest {
        private Long appointmentId;
        private String visitType;
        private String notes;

        public Long getAppointmentId() {
            return appointmentId;
        }

        public void setAppointmentId(Long appointmentId) {
            this.appointmentId = appointmentId;
        }

        public String getVisitType() {
            return visitType;
        }

        public void setVisitType(String visitType) {
            this.visitType = visitType;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }
    }
}
