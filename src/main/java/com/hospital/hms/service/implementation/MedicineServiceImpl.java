package com.hospital.hms.service.implementation;

import com.hospital.hms.Enum.MedicineStatus;
import com.hospital.hms.dto.MedicineDTO;
import com.hospital.hms.entity.Medicine;
import com.hospital.hms.mapper.MedicineMapper;
import com.hospital.hms.repository.MedicineRepository;
import com.hospital.hms.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {
    private final MedicineRepository medicineRepository;

    @Override
    public List<MedicineDTO> getAllMedicines() {
        return medicineRepository.findAll()
                .stream()
                .map(MedicineMapper::mapToMedicineDTO)
                .toList();
    }

    @Override
    public MedicineDTO getMedicineById(Long id) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
        return MedicineMapper.mapToMedicineDTO(medicine);
    }

    @Override
    public MedicineDTO createMedicine(MedicineDTO medicineDTO) {
        if (medicineRepository.findByName(medicineDTO.getName()).isPresent()) {
            throw new RuntimeException("Medicine already exists");
        }
        Medicine medicine = new Medicine();
        medicine.setName(medicineDTO.getName());
        medicine.setCategory(medicineDTO.getCategory());
        medicine.setManufacturer(medicineDTO.getManufacturer());
        medicine.setStock(medicineDTO.getStock());
        medicine.setMinStock(medicineDTO.getMinStock());
        medicine.setPrice(medicineDTO.getPrice());
        medicine.setExpiryDate(medicineDTO.getExpiryDate());
        medicine.setDescription(medicineDTO.getDescription());
        medicine.setSideEffects(medicineDTO.getSideEffects());
        medicine.setDosageForm(medicineDTO.getDosageForm());
        medicine.setStatus(getMedicineStatus(medicineDTO.getStock(), medicineDTO.getMinStock()));

        Medicine savedMedicine = medicineRepository.save(medicine);
        return MedicineMapper.mapToMedicineDTO(savedMedicine);
    }

    @Override
    public MedicineStatus getMedicineStatus(Integer stock, Integer minStock) {
        if (stock <= 0) {
            return MedicineStatus.OUT_OF_STOCK;
        } else if (stock <= minStock) {
            return MedicineStatus.LOW_STOCK;
        } else {
            return MedicineStatus.IN_STOCK;
        }
    }

    @Override
    public MedicineDTO updateMedicine(Long id, MedicineDTO medicineDTO) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));

        medicine.setCategory(medicineDTO.getCategory());
        medicine.setManufacturer(medicineDTO.getManufacturer());
        medicine.setStock(medicineDTO.getStock());
        medicine.setMinStock(medicineDTO.getMinStock());
        medicine.setPrice(medicineDTO.getPrice());
        medicine.setExpiryDate(medicineDTO.getExpiryDate());
        medicine.setDescription(medicineDTO.getDescription());
        medicine.setSideEffects(medicineDTO.getSideEffects());
        medicine.setStatus(getMedicineStatus(medicineDTO.getStock(), medicineDTO.getMinStock()));

        Medicine updatedMedicine = medicineRepository.save(medicine);
        return MedicineMapper.mapToMedicineDTO(updatedMedicine);
    }

    @Override
    public void deleteMedicine(Long id) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
        medicineRepository.delete(medicine);
    }

    @Override
    public List<MedicineDTO> searchMedicines(String query) {
        return medicineRepository.findByNameContainingIgnoreCase(query)
                .stream()
                .map(MedicineMapper::mapToMedicineDTO)
                .toList();
    }

    @Override
    public List<MedicineDTO> getMedicinesByCategory(String category) {
        return medicineRepository.findByCategory(category)
                .stream()
                .map(MedicineMapper::mapToMedicineDTO)
                .toList();
    }

    @Override
    public List<MedicineDTO> getLowStockMedicines() {
        return medicineRepository.findAll()
                .stream()
                .filter(m -> m.getStock() <= m.getMinStock())
                .map(MedicineMapper::mapToMedicineDTO)
                .toList();
    }

    @Override
    public MedicineDTO updateStock(Long id, Integer quantity) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));

        medicine.setStock(medicine.getStock() + quantity);
        medicine.setStatus(getMedicineStatus(medicine.getStock(), medicine.getMinStock()));

        Medicine updatedMedicine = medicineRepository.save(medicine);
        return MedicineMapper.mapToMedicineDTO(updatedMedicine);
    }


}

