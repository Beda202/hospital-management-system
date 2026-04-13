package com.hospital.hms.mapper;

import com.hospital.hms.Enum.EmploymentStatus;
import com.hospital.hms.Enum.UserRole;
import com.hospital.hms.Enum.UserStatus;
import com.hospital.hms.dto.NurseDto;
import com.hospital.hms.entity.Nurse;

public class NurseMapper {
    public static NurseDto mapToNurseDto(Nurse nurse){
        return NurseDto.builder()
                .id(nurse.getId())
                .username(nurse.getUsername())
                .name(nurse.getName())
                .email(nurse.getEmail())
                .phone(nurse.getPhone())
                .role(nurse.getRole().toString())
                .nationalId(nurse.getNationalId())
                .password(nurse.getPassword())
                .address(nurse.getAddress())
                .avatar(nurse.getAvatar())
                .status(nurse.getUserStatus().toString())
                .licenseNumber(nurse.getLicenseNumber())
                .yearsOfExperience(nurse.getYearsOfExperience())
                .hireDate(nurse.getHireDate())
                .employmentStatus(nurse.getEmploymentStatus().toString())
                .shift(nurse.getShift())
                .specialization(nurse.getSpecialization())
                .build();
    }
    public static Nurse mapToNurse(NurseDto nurse){
        return Nurse.builder()
                .id(nurse.getId())
                .username(nurse.getUsername())
                .name(nurse.getName())
                .email(nurse.getEmail())
                .phone(nurse.getPhone())
                .role(UserRole.valueOf(nurse.getRole().toUpperCase().trim()))
                .nationalId(nurse.getNationalId())
                .password(nurse.getPassword())
                .address(nurse.getAddress())
                .avatar(nurse.getAvatar())
                .userStatus(UserStatus.valueOf(nurse.getStatus().toUpperCase().trim()))
                .licenseNumber(nurse.getLicenseNumber())
                .yearsOfExperience(nurse.getYearsOfExperience())
                .hireDate(nurse.getHireDate())
                .employmentStatus(EmploymentStatus.valueOf(nurse.getEmploymentStatus().toUpperCase().trim()))
                .shift(nurse.getShift())
                .specialization(nurse.getSpecialization())
                .build();
    }
}
