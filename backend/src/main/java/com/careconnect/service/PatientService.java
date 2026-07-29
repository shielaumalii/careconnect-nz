package com.careconnect.service;

import com.careconnect.entity.Patient;
import com.careconnect.exception.PatientNotFoundException;
import com.careconnect.repository.PatientRepository;
import com.careconnect.dto.PatientRequestDTO;
import com.careconnect.dto.PatientResponseDTO;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getAllPatients() {

        List<Patient> patients = patientRepository.findAll();

        List<PatientResponseDTO> responseList = new ArrayList<>();

        for (Patient patient : patients) {

            PatientResponseDTO response = new PatientResponseDTO();

            response.setId(patient.getId());
            response.setFirstName(patient.getFirstName());
            response.setLastName(patient.getLastName());
            response.setEmail(patient.getEmail());
            response.setPhoneNumber(patient.getPhoneNumber());

            responseList.add(response);
        }

        return responseList;
    }

    public PatientResponseDTO savePatient(PatientRequestDTO request) {

        Patient patient = new Patient();

        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setEmail(request.getEmail());
        patient.setPhoneNumber(request.getPhoneNumber());

        Patient savedPatient = patientRepository.save(patient);

        PatientResponseDTO response = new PatientResponseDTO();

        response.setId(savedPatient.getId());
        response.setFirstName(savedPatient.getFirstName());
        response.setLastName(savedPatient.getLastName());
        response.setEmail(savedPatient.getEmail());
        response.setPhoneNumber(savedPatient.getPhoneNumber());

        return response;
    }

    public PatientResponseDTO getPatientById(Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));

        PatientResponseDTO response = new PatientResponseDTO();

        response.setId(patient.getId());
        response.setFirstName(patient.getFirstName());
        response.setLastName(patient.getLastName());
        response.setEmail(patient.getEmail());
        response.setPhoneNumber(patient.getPhoneNumber());

        return response;
    }

    public PatientResponseDTO updatePatient(Long id, PatientRequestDTO request) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));

        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setEmail(request.getEmail());
        patient.setPhoneNumber(request.getPhoneNumber());

        Patient updatedPatient = patientRepository.save(patient);

        PatientResponseDTO response = new PatientResponseDTO();

        response.setId(updatedPatient.getId());
        response.setFirstName(updatedPatient.getFirstName());
        response.setLastName(updatedPatient.getLastName());
        response.setEmail(updatedPatient.getEmail());
        response.setPhoneNumber(updatedPatient.getPhoneNumber());

        return response;
    }

    public void deletePatient(Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));

        patientRepository.delete(patient);
    }
}