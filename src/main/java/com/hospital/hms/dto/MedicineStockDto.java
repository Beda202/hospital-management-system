package com.hospital.hms.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MedicineStockDto {
    private Long id;
    private String manufacturer;
    private Integer reOrderLevel;
    private Double sellingPrice;
    private Double unitPurchase;  //price pharmacy paid for each unit
    private String medicineForm;  //tablets, syrup
    private LocalDate expiryDate;
    private String storageLocation;   //Aisle 3, shelf B
    private String dosage;             //how much to take each time tablet "50mg",syrup "25mg/5ml"
    private String packageSize;          // "box of 16 tablets", "100ml bottle"
    private Integer purchaseQuantity;
    private Integer currentQuantity;
    private Long medicineId;
}
