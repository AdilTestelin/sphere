package com.adiltestelin.sphere.service.implementation;

import com.adiltestelin.sphere.enums.RoleEnum;
import com.adiltestelin.sphere.exception.MailAlreadyExistsException;
import com.adiltestelin.sphere.exception.UsernameAlreadyExistsException;
import com.adiltestelin.sphere.mapper.UserMapper;
import com.adiltestelin.sphere.model.Role;
import com.adiltestelin.sphere.model.User;
import com.adiltestelin.sphere.model.dto.RegistrationInputDTO;
import com.adiltestelin.sphere.repository.RoleRepository;
import com.adiltestelin.sphere.repository.UserRepository;
import com.adiltestelin.sphere.service.UserService;
import com.adiltestelin.sphere.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final RoleRepository roleRepository;

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

    final Role userRole = roleRepository.findByName(RoleEnum.USER.name());
    final User user = userMapper.registrationInputDTOtoUser(registrationInputDTO, hashedPassword);
    user.setRole(userRole);

    userRepository.save(user);
  }

  @Override
  public UserDetailsService userDetailsService() {
    return username -> userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

  private Boolean checkIfMailExists(String mail) {
    return userRepository.existsByMail(mail);
  }

  private Boolean checkIfUsernameExists(String username) {
    return userRepository.existsByUsername(username);
  }


}
