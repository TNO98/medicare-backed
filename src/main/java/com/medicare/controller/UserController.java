package com.medicare.controller;


import com.medicare.payload.ApiResponse;
import com.medicare.payload.UserDto;
import com.medicare.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@CrossOrigin(origins ={"*"})
public class UserController {
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable long id){
        return ResponseEntity.ok(userService.findUserById(id));
    }
    @GetMapping("/email")
    public ResponseEntity<UserDto> findUserById(@RequestParam("email") String email){
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long id, @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.updateUser(id,userDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(new ApiResponse("User deleted successfully",true),HttpStatus.OK);
    }

}
