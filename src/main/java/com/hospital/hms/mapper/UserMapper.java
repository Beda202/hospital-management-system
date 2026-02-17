package com.hospital.hms.mapper;

import com.hospital.hms.dto.UserDto;
import com.hospital.hms.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole().toString())
                .department(user.getDepartment())
                .specialty(user.getSpecialty())
                .avatar(user.getAvatar())
                .status(user.getStatus().toString())
                .build();
    }
}
