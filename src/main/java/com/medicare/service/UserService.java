package com.medicare.service;

import com.medicare.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto findUserById(Long id);

    UserDto findUserByEmail(String email);

    List<UserDto> getAllUser();

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);
}
