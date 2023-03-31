package com.medicare.auth;

import com.medicare.config.JwtService;
import com.medicare.entity.Role;
import com.medicare.entity.User;
import com.medicare.payload.UserDto;
import com.medicare.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = UserDto.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();


        var jwtToken = jwtService.generateJwtToken(modelMapper.map(userService.createUser(user), User.class));

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var user = userService.findUserByEmail(authenticationRequest.getEmail());

        var jwtToken = jwtService.generateJwtToken(modelMapper.map(userService.createUser(user), User.class));

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
