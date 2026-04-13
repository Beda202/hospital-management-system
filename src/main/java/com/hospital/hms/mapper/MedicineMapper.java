package com.hospital.hms.mapper;

import com.hospital.hms.Enum.MedicineStatus;
import com.hospital.hms.dto.MedicineDto;
import com.hospital.hms.entity.Medicine;

import java.time.LocalDate;

public class MedicineMapper {
    public static MedicineDto mapToMedicineDto(Medicine medicine){
        return MedicineDto.builder()
                .id(medicine.getId())
                .name(medicine.getName())
                .genericName(medicine.getGenericName())
                .sideEffects(medicine.getSideEffects())
                .description(medicine.getDescription())
                .prescriptionRequired(medicine.getPrescriptionRequired())
                .status(medicine.getStatus().toString())
                .createdAt(medicine.getCreatedAt())
                .updatedAt(medicine.getUpdatedAt())
                .build();
    }
    public static Medicine mapToMedicine(MedicineDto medicine){
        return Medicine.builder()
                .id(medicine.getId())
                .name(medicine.getName())
                .genericName(medicine.getGenericName())
                .sideEffects(medicine.getSideEffects())
                .description(medicine.getDescription())
                .prescriptionRequired(medicine.getPrescriptionRequired())
                .status(MedicineStatus.valueOf(medicine.getStatus().trim().toUpperCase()))
                .createdAt(medicine.getCreatedAt())
                .updatedAt(medicine.getUpdatedAt())
                .build();
    }
}
