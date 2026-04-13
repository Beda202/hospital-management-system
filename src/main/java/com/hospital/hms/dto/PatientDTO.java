package com.hospital.hms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PatientDTO extends UserDto{
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    private String gender;
    private String bloodType;
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
