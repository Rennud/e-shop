package com.example.eshopbackend.payload.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class JwtResponse {

    private final String token;

    private final Long id;

    private final String username;

    private final String email;

    private String type = "Bearer";
}