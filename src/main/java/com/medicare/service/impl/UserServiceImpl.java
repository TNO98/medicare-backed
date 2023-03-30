package com.medicare.service.impl;

import com.medicare.entity.Role;
import com.medicare.entity.User;
import com.medicare.exception.ResourceNotFoundException;
import com.medicare.payload.UserDto;
import com.medicare.repository.UserRepository;
import com.medicare.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto findUserById(Long id) {
        User foundUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        return modelMapper.map(foundUser, UserDto.class);
    }

    @Override
    public UserDto findUserByEmail(String email) {
        User foundUser = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
        return modelMapper.map(foundUser, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
    }

    @Override
    public UserDto updateUser(Long id, UserDto newUserDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.setName(newUserDto.getName());
        user.setPassword(newUserDto.getPassword());
        user.setEmail(newUserDto.getEmail());
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser,UserDto.class);
    }

    @Override

    public void deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) userRepository.deleteById(id);
        else throw new ResourceNotFoundException("User", "id", id);
    }

    @PostConstruct
    public void init(){
        User user =User.builder().name("Malay Sarkar")
                .email("malay@gmail.com")
                .password("abc123")
                .role(Role.ADMIN)
                .build();
        if(!userRepository.existsByEmail(user.getEmail())) this.userRepository.save(user);
    }
}
