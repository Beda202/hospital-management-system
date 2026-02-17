package com.hospital.hms.mapper;

import com.hospital.hms.dto.PatientDTO;
import com.hospital.hms.entity.Patient;

public class PatientMapper {
    public static PatientDTO mapToPatientDto(Patient patient) {

        return PatientDTO.builder()
                .id(patient.getId())
                .userId(patient.getUser() != null ? patient.getUser().getId() : null)
                .name(patient.getName())
                .nationalId(patient.getNationalId())
                .dateOfBirth(patient.getDateOfBirth())
                .gender(patient.getGender().toString())
                .bloodType(patient.getBloodType())
                .phone(patient.getPhone())
                .email(patient.getEmail())
                .address(patient.getAddress())
                .emergencyContact(patient.getEmergencyContact())
                .insuranceProvider(patient.getInsuranceProvider())
                .insuranceNumber(patient.getInsuranceNumber())
                .allergies(patient.getAllergies())
                .medicalHistory(patient.getMedicalHistory())
                .diagnosis(patient.getDiagnosis())
                .notes(patient.getNotes())
                .status(patient.getStatus().toString())
                .bloodPressure(patient.getBloodPressure())
                .temperature(patient.getTemperature())
                .pulse(patient.getPulse())
                .weight(patient.getWeight())
                .height(patient.getHeight())
                .build();
    }
}
