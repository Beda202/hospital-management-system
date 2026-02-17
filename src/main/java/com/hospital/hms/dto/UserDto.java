package com.hospital.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String name;
    private String email;
    private String phone;
    private String role;
    private String department;
    private String specialty;
    private String avatar;
    private String status;
}
