package com.careconnect.controller;

import com.careconnect.dto.PatientRequestDTO;
import com.careconnect.dto.PatientResponseDTO;
import com.careconnect.entity.Patient;
import com.careconnect.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientResponseDTO> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping
    public PatientResponseDTO createPatient(
            @Valid @RequestBody PatientRequestDTO request) {

        return patientService.savePatient(request);
    }

    @GetMapping("/{id}")
    public PatientResponseDTO getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PutMapping("/{id}")
    public PatientResponseDTO updatePatient(
            @PathVariable Long id,
            @Valid @RequestBody PatientRequestDTO request) {

        return patientService.updatePatient(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}