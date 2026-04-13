package com.hospital.hms.dto;

import com.hospital.hms.Enum.EmploymentStatus;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DoctorDto extends UserDto{

    private String licenseNumber;
    private String specialization;
    private String qualification;
    private String medicalSchool;
    private Integer yearOfGraduation;
    private Integer yearsOfExperience;
    private LocalDate hireDate;
    private String employmentStatus;
    private String shift;
}
