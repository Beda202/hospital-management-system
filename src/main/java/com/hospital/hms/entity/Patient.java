package com.hospital.hms.entity;

import com.hospital.hms.Enum.Gender;
import com.hospital.hms.Enum.PatientStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String nationalId;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private String bloodType;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String address;

    @Column(nullable = false)
    private String emergencyContact;

    private String insuranceProvider;
    private String insuranceNumber;

    @Column(columnDefinition = "LONGTEXT")
    private String allergies;

    @Column(columnDefinition = "LONGTEXT")
    private String medicalHistory;

    private String diagnosis;
    private String notes;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PatientStatus status = PatientStatus.ACTIVE;

    private String bloodPressure;
    private String temperature;
    private String pulse;
    private String weight;
    private String height;
    private LocalDateTime vitalsLastUpdated;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
