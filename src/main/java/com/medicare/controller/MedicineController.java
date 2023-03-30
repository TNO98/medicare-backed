package com.medicare.controller;


import com.medicare.payload.ApiResponse;
import com.medicare.payload.MedicineDto;
import com.medicare.service.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
@AllArgsConstructor
public class MedicineController {

    private MedicineService medicineService;

    @GetMapping("/")
    public ResponseEntity<List<MedicineDto>> getAllMedicine(){
        return new ResponseEntity<>(medicineService.getAllMedicine(), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<MedicineDto> saveMedicine(@RequestBody MedicineDto medicineDto){
        return new ResponseEntity<>(medicineService.saveMedicine(medicineDto),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineDto> getMedicine(@PathVariable Long id){
        return ResponseEntity.ok(medicineService.getMedicineById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicineDto> updateMedicine(@PathVariable Long id, @RequestBody MedicineDto updatedMedicine){
        return ResponseEntity.ok(medicineService.updateMedicine(id,updatedMedicine));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedicine(@PathVariable Long id){
        this.medicineService.deleteMedicine(id);
        return ResponseEntity.ok(new ApiResponse("Medicine deleted Successfully",true));
    }

}
