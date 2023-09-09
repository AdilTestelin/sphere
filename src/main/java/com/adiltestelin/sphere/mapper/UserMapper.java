package com.adiltestelin.sphere.mapper;

import com.adiltestelin.sphere.model.User;
import com.adiltestelin.sphere.model.dto.RegistrationInputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "mail", source = "registrationInputDTO.mail")
    @Mapping(target = "username", source = "registrationInputDTO.username")
    @Mapping(target = "password", source = "hashedPassword")
    User registrationInputDTOtoUser(RegistrationInputDTO registrationInputDTO, String hashedPassword);
}
