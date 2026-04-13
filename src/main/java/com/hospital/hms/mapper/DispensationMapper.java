package com.hospital.hms.mapper;

import com.hospital.hms.Enum.DispensationStatus;
import com.hospital.hms.dto.MedicineDispensationDto;
import com.hospital.hms.entity.MedicineDispensation;

public class DispensationMapper {
    public static MedicineDispensationDto mapToDto(MedicineDispensation dispensation){
        return MedicineDispensationDto.builder()
                .id(dispensation.getId())
                .dispensedDate(dispensation.getDispensedDate())
                .dispensedQuantity(dispensation.getDispensedQuantity())
                .charges(dispensation.getCharges())
                .status(dispensation.getStatus().toString())
                .build();
    }
    public static MedicineDispensation mapFromDto(MedicineDispensationDto dispensation){
        return MedicineDispensation.builder()
                .id(dispensation.getId())
                .dispensedDate(dispensation.getDispensedDate())
                .dispensedQuantity(dispensation.getDispensedQuantity())
                .charges(dispensation.getCharges())
                .status(DispensationStatus.valueOf(dispensation.getStatus()))
                .build();
    }
}
