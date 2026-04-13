package com.hospital.hms.mapper;

import com.hospital.hms.Enum.EmploymentStatus;
import com.hospital.hms.Enum.UserRole;
import com.hospital.hms.Enum.UserStatus;
import com.hospital.hms.dto.DoctorDto;
import com.hospital.hms.entity.Doctor;

import java.time.LocalDate;

public class DoctorMapper {

    public static DoctorDto mapToDoctorDto(Doctor doctor){
        return DoctorDto.builder()
                .id(doctor.getId())
                .username(doctor.getUsername())
                .name(doctor.getName())
                .email(doctor.getEmail())
                .phone(doctor.getPhone())
                .role(doctor.getRole().toString())
                .nationalId(doctor.getNationalId())
                .password(doctor.getPassword())
                .address(doctor.getAddress())
                .avatar(doctor.getAvatar())
                .status(doctor.getUserStatus().toString())
                .licenseNumber(doctor.getLicenseNumber())
                .specialization(doctor.getSpecialization())
                .qualification(doctor.getQualification())
                .medicalSchool(doctor.getMedicalSchool())
                .yearOfGraduation(doctor.getYearOfGraduation())
                .yearsOfExperience(doctor.getYearsOfExperience())
                .hireDate(doctor.getHireDate())
                .employmentStatus(doctor.getEmploymentStatus().toString())
                .shift(doctor.getShift())
                .build();
    }

    public static Doctor mapToDoctor(DoctorDto doctorDto){
        return Doctor.builder().id(doctorDto.getId())
                .username(doctorDto.getUsername())
                .name(doctorDto.getName())
                .email(doctorDto.getEmail())
                .phone(doctorDto.getPhone())
                .role(UserRole.valueOf(doctorDto.getRole().toUpperCase().trim()))
                .nationalId(doctorDto.getNationalId())
                .password(doctorDto.getPassword())
                .address(doctorDto.getAddress())
                .avatar(doctorDto.getAvatar())
                .userStatus(UserStatus.valueOf(doctorDto.getStatus().toUpperCase().trim()))
                .licenseNumber(doctorDto.getLicenseNumber())
                .specialization(doctorDto.getSpecialization())
                .qualification(doctorDto.getQualification())
                .medicalSchool(doctorDto.getMedicalSchool())
                .yearOfGraduation(doctorDto.getYearOfGraduation())
                .yearsOfExperience(doctorDto.getYearsOfExperience())
                .hireDate(doctorDto.getHireDate())
                .employmentStatus(EmploymentStatus.valueOf(doctorDto.getEmploymentStatus().toUpperCase().trim()))
                .shift(doctorDto.getShift())
                .build();
    }
}
