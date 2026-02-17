package com.hospital.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDTO {
    private Long id;
    private Long userId;
    private String name;
    private String nationalId;
    private LocalDate dateOfBirth;
    private String gender;
    private String bloodType;
    private String phone;
    private String email;
    private String address;
    private String emergencyContact;
    private String insuranceProvider;
    private String insuranceNumber;
    private String allergies;
    private String medicalHistory;
    private String diagnosis;
    private String notes;
    private String status;

    private String bloodPressure;
    private String temperature;
    private String pulse;
    private String weight;
    private String height;
}
