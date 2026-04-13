package com.hospital.hms.dto;

import com.hospital.hms.Enum.DispensationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDispensationDto {
    private Long id;
    private int dispensedQuantity;
    private LocalDate dispensedDate;
    private String status;
    private Double charges;
}
