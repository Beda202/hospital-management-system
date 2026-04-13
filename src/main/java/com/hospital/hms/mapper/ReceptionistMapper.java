package com.hospital.hms.mapper;

import com.hospital.hms.Enum.EmploymentStatus;
import com.hospital.hms.Enum.UserRole;
import com.hospital.hms.Enum.UserStatus;
import com.hospital.hms.dto.ReceptionistDto;
import com.hospital.hms.entity.Receptionist;

public class ReceptionistMapper {
    public static ReceptionistDto mapToDto(Receptionist receptionist){
        return ReceptionistDto.builder()
                .id(receptionist.getId())
                .username(receptionist.getUsername())
                .name(receptionist.getName())
                .email(receptionist.getEmail())
                .phone(receptionist.getPhone())
                .role(receptionist.getRole().toString())
                .nationalId(receptionist.getNationalId())
                .password(receptionist.getPassword())
                .address(receptionist.getAddress())
                .avatar(receptionist.getAvatar())
                .status(receptionist.getUserStatus().toString())
                .shift(receptionist.getShift())
                .specialityArea(receptionist.getSpecialityArea())
                .customerServiceTraining(receptionist.getCustomerServiceTraining())
                .hipaaTrainingDate(receptionist.getHipaaTrainingDate())
                .employmentStatus(receptionist.getEmploymentStatus().toString())
                .build();
    }
    public static Receptionist mapFromDto(ReceptionistDto receptionist){
        return Receptionist.builder()
                .id(receptionist.getId())
                .username(receptionist.getUsername())
                .name(receptionist.getName())
                .email(receptionist.getEmail())
                .phone(receptionist.getPhone())
                .role(UserRole.valueOf(receptionist.getRole().toUpperCase().trim()))
                .nationalId(receptionist.getNationalId())
                .password(receptionist.getPassword())
                .address(receptionist.getAddress())
                .avatar(receptionist.getAvatar())
                .userStatus(UserStatus.valueOf(receptionist.getStatus().toUpperCase().trim()))
                .shift(receptionist.getShift())
                .specialityArea(receptionist.getSpecialityArea())
                .customerServiceTraining(receptionist.getCustomerServiceTraining())
                .hipaaTrainingDate(receptionist.getHipaaTrainingDate())
                .employmentStatus(EmploymentStatus.valueOf(receptionist.getEmploymentStatus().toUpperCase().trim()))
                .build();
    }
}
