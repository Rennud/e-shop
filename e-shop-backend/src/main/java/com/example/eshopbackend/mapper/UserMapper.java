package com.example.eshopbackend.mapper;

import com.example.eshopbackend.dto.UserDto;
import com.example.eshopbackend.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDto> {
}
