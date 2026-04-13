package com.hospital.hms.mapper;

import com.hospital.hms.Enum.UserRole;
import com.hospital.hms.Enum.UserStatus;
import com.hospital.hms.dto.PharmacistDto;
import com.hospital.hms.entity.Pharmacist;

public class PharmacistMapper {
    public static PharmacistDto mapToDto(Pharmacist pharmacist){
        return PharmacistDto.builder()
                .id(pharmacist.getId())
                .username(pharmacist.getUsername())
                .name(pharmacist.getName())
                .email(pharmacist.getEmail())
                .phone(pharmacist.getPhone())
                .role(pharmacist.getRole().toString())
                .nationalId(pharmacist.getNationalId())
                .password(pharmacist.getPassword())
                .address(pharmacist.getAddress())
                .avatar(pharmacist.getAvatar())
                .status(pharmacist.getUserStatus().toString())
                .shift(pharmacist.getShift())
                .licenseNumber(pharmacist.getLicenseNumber())
                .licenseExpiryDate(pharmacist.getLicenseExpiryDate())
                .build();
    }

    public static Pharmacist mapFromDto(PharmacistDto pharmacist){
        return Pharmacist.builder()
                .id(pharmacist.getId())
                .username(pharmacist.getUsername())
                .name(pharmacist.getName())
                .email(pharmacist.getEmail())
                .phone(pharmacist.getPhone())
                .role(UserRole.valueOf(pharmacist.getRole()))
                .nationalId(pharmacist.getNationalId())
                .password(pharmacist.getPassword())
                .address(pharmacist.getAddress())
                .avatar(pharmacist.getAvatar())
                .userStatus(UserStatus.valueOf(pharmacist.getStatus()))
                .shift(pharmacist.getShift())
                .licenseNumber(pharmacist.getLicenseNumber())
                .licenseExpiryDate(pharmacist.getLicenseExpiryDate())
                .build();
    }
}
