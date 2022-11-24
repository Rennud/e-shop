package com.example.eshopbackend.service;

import com.example.eshopbackend.entity.User;
import com.example.eshopbackend.exception.NotValidInputException;
import com.example.eshopbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * Gets User from DB based on their id
     *
     * @param id of User
     * @return User with given id
     * @throws NotValidInputException when User does not exist in DB.
     */
    public User getById(long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new NotValidInputException("User with given id does not exist!");
        } else {
            return userRepository.findById(id).get();
        }
    }
}
