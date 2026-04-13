package com.hospital.hms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hospital.hms.Enum.EmploymentStatus;
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
public class ReceptionistDto extends UserDto{
    private String shift;
    private String specialityArea; //in patient, out patient
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate hipaaTrainingDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate customerServiceTraining;
    private String employmentStatus;
}
