package com.example.eshopbackend.controller.impl;

import com.example.eshopbackend.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {

    private final EmailService emailService;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/email")
    public String sendEmail(){
        emailService.sendTestMessage("daniel.rakovsky@seznam.cz", "test", "Ahoj Dane :)");
        return "Message send :)";
    }
}
