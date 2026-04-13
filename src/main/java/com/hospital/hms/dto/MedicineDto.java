package com.hospital.hms.dto;

import com.hospital.hms.Enum.MedicineStatus;
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
public class MedicineDto {
    private Long id;
    private String name;
    private String genericName;
    private String status;
    private Boolean prescriptionRequired;
    private String description;
    private String sideEffects;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
