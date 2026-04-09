package com.hospital.hms.mapper;

import com.hospital.hms.dto.MedicineDTO;
import com.hospital.hms.entity.Medicine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public class MedicineMapper {
    public static MedicineDTO mapToMedicineDTO(Medicine medicine){
        return MedicineDTO.builder()
                .id(medicine.getId())
                .name(medicine.getName())
                .category(medicine.getCategory())
                .manufacturer(medicine.getManufacturer())
                .stock(medicine.getStock())
                .minStock(medicine.getMinStock())
                .price(medicine.getPrice())
                .expiryDate(medicine.getExpiryDate())
                .status(medicine.getStatus().toString())
                .description(medicine.getDescription())
                .sideEffects(medicine.getSideEffects())
                .dosageForm(medicine.getDosageForm())
                .build();
    }
}
