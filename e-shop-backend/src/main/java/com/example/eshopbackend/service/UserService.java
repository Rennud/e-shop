package com.example.eshopbackend.service;

import com.example.eshopbackend.entity.User;
import com.example.eshopbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getById(long id){
        return userRepository.findById(id);
    }
}
