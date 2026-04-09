package com.hospital.hms.service;

import com.hospital.hms.Enum.MedicineStatus;
import com.hospital.hms.dto.MedicineDTO;

import java.util.List;

public interface MedicineService {
    public List<MedicineDTO> getAllMedicines();
    public MedicineDTO getMedicineById(Long id);
    public MedicineDTO createMedicine(MedicineDTO medicineDTO);
    public MedicineStatus getMedicineStatus(Integer stock, Integer minStock) ;
    public MedicineDTO updateMedicine(Long id, MedicineDTO medicineDTO);
    public void deleteMedicine(Long id);
    public List<MedicineDTO> searchMedicines(String query);
    public List<MedicineDTO> getMedicinesByCategory(String category);
    public List<MedicineDTO> getLowStockMedicines();
    public MedicineDTO updateStock(Long id, Integer quantity);

    }
