package com.hospital.hms.controller;

import com.hospital.hms.dto.MedicineDTO;
import com.hospital.hms.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medicines")
public class MedicineController {
    private final MedicineService medicineService;

    @GetMapping
    public ResponseEntity<List<MedicineDTO>> getAllMedicines() {
        List<MedicineDTO> medicines = medicineService.getAllMedicines();
        return ResponseEntity.ok(medicines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineDTO> getMedicineById(@PathVariable Long id) {
        MedicineDTO medicine = medicineService.getMedicineById(id);
        return ResponseEntity.ok(medicine);
    }

    @PostMapping
    public ResponseEntity<MedicineDTO> createMedicine(@RequestBody MedicineDTO medicineDTO) {
        MedicineDTO createdMedicine = medicineService.createMedicine(medicineDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedicine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicineDTO> updateMedicine(
            @PathVariable Long id,
            @RequestBody MedicineDTO medicineDTO) {
        MedicineDTO updatedMedicine = medicineService.updateMedicine(id, medicineDTO);
        return ResponseEntity.ok(updatedMedicine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.ok("Medicine deleted successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List<MedicineDTO>> searchMedicines(@RequestParam String query) {
        List<MedicineDTO> medicines = medicineService.searchMedicines(query);
        return ResponseEntity.ok(medicines);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<MedicineDTO>> getMedicinesByCategory(@PathVariable String category) {
        List<MedicineDTO> medicines = medicineService.getMedicinesByCategory(category);
        return ResponseEntity.ok(medicines);
    }

    @GetMapping("/stock/low")
    public ResponseEntity<List<MedicineDTO>> getLowStockMedicines() {
        List<MedicineDTO> medicines = medicineService.getLowStockMedicines();
        return ResponseEntity.ok(medicines);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<MedicineDTO> updateStock(
            @PathVariable Long id,
            @RequestParam Integer quantity) {
        MedicineDTO updatedMedicine = medicineService.updateStock(id, quantity);
        return ResponseEntity.ok(updatedMedicine);
    }
}
