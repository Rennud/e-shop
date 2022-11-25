package com.example.eshopbackend.service;

import com.example.eshopbackend.entity.User;
import com.example.eshopbackend.exception.NotValidInputException;
import com.example.eshopbackend.repository.UserRepository;
import com.example.eshopbackend.security.jwt.JwtUtils;
import com.example.eshopbackend.security.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final JwtUtils jwtUtils;

    private final UserDetailsServiceImpl userDetailsService;

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

    /**
     * Return User Entity based on token. Searches by username.
     * @param token whole token even with Bearer at the begining
     * @return User from DB
     */
    public User getUserFromToken(String token){
        token = token.substring(6);
        if(userRepository.findByUsername(jwtUtils.getUserNameFromJwtToken(token)).isEmpty()){
            throw new NotValidInputException("Could not find User in DB from given token");
        }
        return userRepository.findByUsername(jwtUtils.getUserNameFromJwtToken(token)).get();
    }
}
