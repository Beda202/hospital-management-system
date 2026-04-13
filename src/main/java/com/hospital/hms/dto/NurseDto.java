package com.hospital.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class NurseDto extends UserDto{
    private String licenseNumber;
    private String specialization;
    private Integer yearsOfExperience;
    private LocalDate hireDate;
    private String employmentStatus;
    private String shift;

}
