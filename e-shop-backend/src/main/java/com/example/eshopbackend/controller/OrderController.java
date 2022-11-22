package com.example.eshopbackend.controller;

import com.example.eshopbackend.dto.OrderDto;
import com.example.eshopbackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/order")
public class OrderController {

    private final OrderService orderService;


    @GetMapping(value = "/{id}", produces = "application/json")
    public OrderDto getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }
}
