package com.medicare.service;

import com.medicare.payload.MedicineDto;

import java.util.List;

public interface MedicineService {
    //get a medicine
    MedicineDto getMedicineById(long id);

    // get all medicine

    List<MedicineDto> getAllMedicine();

    // save a medicine
    MedicineDto saveMedicine(MedicineDto medicineDto);

    // update a medicine

    MedicineDto updateMedicine(Long id, MedicineDto medicine);

    //Delete a medicine
    void deleteMedicine(long id);



}
