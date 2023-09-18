package com.adiltestelin.sphere.service.implementation;

import com.adiltestelin.sphere.enums.RoleEnum;
import com.adiltestelin.sphere.exception.MailAlreadyExistsException;
import com.adiltestelin.sphere.exception.UsernameAlreadyExistsException;
import com.adiltestelin.sphere.mapper.UserMapper;
import com.adiltestelin.sphere.model.Role;
import com.adiltestelin.sphere.model.User;
import com.adiltestelin.sphere.model.dto.RegistrationRequest;
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

  @Override
  public UserDetailsService userDetailsService() {
    return username -> userRepository.findByMail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }




}
