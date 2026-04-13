package com.hospital.hms.dto;

import com.hospital.hms.entity.Pharmacist;
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
public class PharmacistDto extends UserDto{
    private String licenseNumber;
    private LocalDate licenseExpiryDate;
    private String shift;
}
