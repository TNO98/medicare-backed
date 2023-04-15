package com.medicare.controller;
import com.medicare.payload.ApiResponse;
import com.medicare.payload.MedicineDto;
import com.medicare.service.FileService;
import com.medicare.service.MedicineService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/medicine")
@RequiredArgsConstructor
@CrossOrigin(origins ={"*"})
public class MedicineController {
    private final FileService fileService;
    private final MedicineService medicineService;
    @Value("${project.image}")
    private String path;

    @GetMapping("/")
    public ResponseEntity<List<MedicineDto>> getAllMedicine(){
        return new ResponseEntity<>(medicineService.getAllMedicine(), HttpStatus.OK);
    }
    @PostMapping(value = "/",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<MedicineDto> saveMedicine(@RequestPart MedicineDto medicineDto, @RequestPart MultipartFile image) throws IOException {
        String imageName=fileService.uploadImage(path,image);
        medicineDto.setImageName(imageName);
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

    //method to upload image
    @GetMapping( value="image/{imageName}" , produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
            @PathVariable("imageName") String imageName,
            HttpServletResponse response
    ) throws IOException {

        InputStream resource = this.fileService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }

}
