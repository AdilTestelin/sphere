package com.adiltestelin.sphere.service.implementation;

import com.adiltestelin.sphere.exception.MailAlreadyExistsException;
import com.adiltestelin.sphere.exception.UsernameAlreadyExistsException;
import com.adiltestelin.sphere.mapper.UserMapper;
import com.adiltestelin.sphere.model.User;
import com.adiltestelin.sphere.model.dto.RegistrationInputDTO;
import com.adiltestelin.sphere.model.dto.RegistrationOutputDTO;
import com.adiltestelin.sphere.repository.UserRepository;
import com.adiltestelin.sphere.service.UserService;
import com.adiltestelin.sphere.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final UserUtil userUtil;

    @Override
    public void registerUser(RegistrationInputDTO registrationInputDTO) {
        final String mail = registrationInputDTO.mail();
        final String username = registrationInputDTO.username();
        final String password = registrationInputDTO.password();

        if (checkIfMailExists(mail)) {
            throw new MailAlreadyExistsException(String.format("Mail %s already exists", mail));
        }

        if (checkIfUsernameExists(username)) {
            throw new UsernameAlreadyExistsException(String.format("Username %s already exists", username));
        }

        final String hashedPassword = userUtil.hashPassword(password);

        final User user = userMapper.registrationInputDTOtoUser(registrationInputDTO, hashedPassword);

        userRepository.save(user);
    }

    private boolean checkIfMailExists(String mail) {
        return userRepository.existsByMail(mail);
    }

    private boolean checkIfUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }


}
