package com.hospital.hms.service.implementation;

import com.hospital.hms.Enum.UserRole;
import com.hospital.hms.Enum.UserStatus;
import com.hospital.hms.dto.authentication.LoginRequest;
import com.hospital.hms.dto.authentication.LoginResponse;
import com.hospital.hms.dto.UserDto;
import com.hospital.hms.entity.User;
import com.hospital.hms.exception.InvalidPasswordException;
import com.hospital.hms.exception.PasswordEmptyException;
import com.hospital.hms.exception.UserNameAlreadyExistException;
import com.hospital.hms.exception.UserNotFoundException;
import com.hospital.hms.mapper.UserMapper;
import com.hospital.hms.repository.UserRepository;
import com.hospital.hms.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository ;
    private final PasswordEncoder passwordEncoder ;

    @Override
    public LoginResponse login(LoginRequest request) throws Exception {
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UserNotFoundException("User Not Found !"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException("Invalid password") ;
        }


        return LoginResponse.builder()
                .AccessToken("mock-jwt-token-" )
                .refreshToken("mock-refresh-token-")
                .type("Bearer")
                .user(UserMapper.mapToUserDto(user))
                .build();
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper ::mapToUserDto )
                .toList();
    }

    @Override
    public List<UserDto> getUsersByRole(String role) {
        UserRole userRole = UserRole.valueOf(role.toUpperCase());
        return userRepository.findByRole(userRole)
                .stream()
                .map(UserMapper::mapToUserDto)
                .toList();
    }

    @Override
    public List<UserDto> searchUsers(String query) {
        return userRepository.findByNameContainingIgnoreCase(query)
                .stream()
                .map(UserMapper::mapToUserDto)
                .toList();
    }

    @Override
    public UserDto createUser(UserDto userDTO) {
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            throw new UserNameAlreadyExistException("Username already exists");
        }

        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());

        user.setPassword(passwordEncoder.encode("beda123"));


        user.setRole(UserRole.valueOf(userDTO.getRole().toUpperCase()));
        user.setDepartment(userDTO.getDepartment());
        user.setSpecialty(userDTO.getSpecialty());
        user.setStatus(UserStatus.ACTIVE);

        User savedUser = userRepository.save(user);
       UserDto userDto =UserMapper.mapToUserDto(savedUser);
        return userDto;
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setDepartment(userDTO.getDepartment());
        user.setSpecialty(userDTO.getSpecialty());
        user.setAvatar(userDTO.getAvatar());

        User updatedUser = userRepository.save(user);
        UserDto userDto = UserMapper.mapToUserDto(updatedUser);

        return userDto ;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public UserDto getCurrentUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public void changePassword(Long userId, String oldPassword, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new InvalidPasswordException("Invalid old password");
        }

        if (newPassword == null || newPassword.trim().isEmpty()) {
            throw new PasswordEmptyException("New password cannot be empty");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

    }

    @Override
    public void resetPassword(Long userId, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }


}

