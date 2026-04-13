package com.hospital.hms.service.implementation;

import com.hospital.hms.dto.DepartmentDto;
import com.hospital.hms.entity.Department;
import com.hospital.hms.mapper.DepartmentMapper;
import com.hospital.hms.repository.DepartmentRepository;
import com.hospital.hms.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        if(departmentRepository.findByNameContainingIgnoreCase(departmentDto.getName()).isPresent())
            throw new RuntimeException("Name already used, please choose a different name");

        Department department= DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment= departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department= departmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Department not found"));
        departmentRepository.delete(department);
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
        if(departmentRepository.findByNameContainingIgnoreCase(departmentDto.getName()).isPresent())
            throw new RuntimeException("Name already used, please choose a different name");

        departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        return DepartmentMapper.mapToDepartmentDto(departmentRepository.save(department));

    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department= departmentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Department not found"));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll().stream().
                map(DepartmentMapper::mapToDepartmentDto).toList();
    }

    @Override
    public DepartmentDto getDepartmentByName(String name) {
        Department department= departmentRepository.findByNameContainingIgnoreCase(name)
                .orElseThrow(()->new RuntimeException("Department not found, please check the name"));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getDepartmentByStatus(boolean active) {
        return departmentRepository.findByActive(active)
                .stream().map(DepartmentMapper::mapToDepartmentDto).toList();
    }

}
