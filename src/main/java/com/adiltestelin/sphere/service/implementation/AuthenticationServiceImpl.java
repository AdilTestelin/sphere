package com.adiltestelin.sphere.service.implementation;

import com.adiltestelin.sphere.enums.RoleEnum;
import com.adiltestelin.sphere.exception.MailAlreadyExistsException;
import com.adiltestelin.sphere.exception.UsernameAlreadyExistsException;
import com.adiltestelin.sphere.mapper.UserMapper;
import com.adiltestelin.sphere.model.Role;
import com.adiltestelin.sphere.model.User;
import com.adiltestelin.sphere.model.dto.AuthenticationRequest;
import com.adiltestelin.sphere.model.dto.AuthenticationResponse;
import com.adiltestelin.sphere.model.dto.RegistrationRequest;
import com.adiltestelin.sphere.model.dto.RegistrationResponse;
import com.adiltestelin.sphere.repository.RoleRepository;
import com.adiltestelin.sphere.repository.UserRepository;
import com.adiltestelin.sphere.service.AuthenticationService;
import com.adiltestelin.sphere.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final UserMapper userMapper;


    @Override
    @Transactional
    public RegistrationResponse signUp(RegistrationRequest registrationRequest) {
        final String mail = registrationRequest.mail();
        final String username = registrationRequest.username();
        final String password = registrationRequest.password();

        if (checkIfMailExists(mail)) {
            throw new MailAlreadyExistsException(String.format("Mail %s already exists", mail));
        }

        if (checkIfUsernameExists(username)) {
            throw new UsernameAlreadyExistsException(String.format("Username %s already exists", username));
        }

        final String hashedPassword = passwordEncoder.encode(password);
        final Role userRole = roleRepository.findByName(RoleEnum.USER.name());
        final User user = userMapper.registrationRequestToUser(registrationRequest, hashedPassword);
        user.setRole(userRole);

        userRepository.save(user);

        final String jwt = jwtService.generateToken(user);

        return new RegistrationResponse(jwt);
    }

    @Override
    public AuthenticationResponse signIn(final AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.mail(), authenticationRequest.password())
        );

        final Optional<User> user = Optional.ofNullable(userRepository.findByMail(authenticationRequest.mail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password")));

        final String jwt = jwtService.generateToken(user.get());
        return new AuthenticationResponse(jwt);
    }

    private boolean checkIfMailExists(String mail) {
        return userRepository.existsByMail(mail);
    }

    private boolean checkIfUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }
}
