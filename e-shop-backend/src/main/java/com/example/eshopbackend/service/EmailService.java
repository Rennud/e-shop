package com.example.eshopbackend.service;

import com.example.eshopbackend.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendTestMessage(

            String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom("java.beans@seznam.cz");

        emailSender.send(message);
    }

    public void sendConfirmationEmail(OrderDto order){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(order.user().getEmail());
        message.setSubject("Order " + order.id());
        message.setFrom("java.beans@seznam.cz");

        AtomicReference<String> text = new AtomicReference<>("Thank you for your order.\n");

        order.itemList()
                .stream()
                .map(i -> i.getName() + " " + i.getPrice() + "$\n")
                .forEach(s -> text.set(text + s));

        text.set(text + "\nTOTAL " + order.totalPrice() + "$");

        message.setText(text.get());

        emailSender.send(message);
    }
}
