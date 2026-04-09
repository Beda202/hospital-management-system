package com.hospital.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicineDTO {

    private Long id;
    private String name;
    private String category;
    private String manufacturer;
    private Integer stock;
    private Integer minStock;
    private Double price;
    private LocalDate expiryDate;
    private String status;
    private String description;
    private String sideEffects;
    private String dosageForm;
}
