package com.medicare.service.impl;
import com.medicare.entity.Medicine;
import com.medicare.exception.ResourceNotFoundException;
import com.medicare.payload.MedicineDto;
import com.medicare.repository.MedicineRepository;
import com.medicare.service.MedicineService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService {
    private final MedicineRepository medicineRepository;
    private ModelMapper modelMapper;
    @Override
    public MedicineDto getMedicineById(long id) {
       Medicine medicine=medicineRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Medicine", "id",id));
       return modelMapper.map(medicine, MedicineDto.class);
    }

    @Override
    public List<MedicineDto> getAllMedicine() {
        return medicineRepository.findAll().stream()
                .map(medicine -> modelMapper.map(medicine,MedicineDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MedicineDto saveMedicine(MedicineDto medicineDto) {
        return modelMapper.map(medicineRepository.save(modelMapper.map(medicineDto,Medicine.class)),MedicineDto.class);
    }

    @Override
    public MedicineDto updateMedicine(Long id, MedicineDto updatedMedicine) {

        Medicine oldMedicine =medicineRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Medicine", "Id", id));
//        oldMedicine.setName(updatedMedicine.getName());
//        oldMedicine.setBrand(updatedMedicine.getBrand());
//        oldMedicine.setPrice(updatedMedicine.getPrice());
//        oldMedicine.setImageName(updatedMedicine.getImageName());
//        oldMedicine.setUnitsAvailable(updatedMedicine.getUnitsAvailable());
//        oldMedicine.setCategory(updatedMedicine.getCategory());
        updatedMedicine.setId(oldMedicine.getId());
        Medicine medicine= medicineRepository.save(modelMapper.map(updatedMedicine,Medicine.class));
        return modelMapper.map(medicine,MedicineDto.class);
    }

    @Override
    public void deleteMedicine(long id) {
       if (medicineRepository.findById(id).isPresent()) medicineRepository.deleteById(id);
       else throw new ResourceNotFoundException("Medicine", "Id", id);
    }
}
