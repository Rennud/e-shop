package com.example.eshopbackend.controller;

import com.example.eshopbackend.dto.ItemDto;
import com.example.eshopbackend.dto.OrderDto;
import com.example.eshopbackend.entity.Order;
import com.example.eshopbackend.entity.User;
import com.example.eshopbackend.service.OrderService;
import com.example.eshopbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/order")
public class OrderController {

    private final OrderService orderService;

    private final UserService userService;


    @GetMapping(value = "/{id}", produces = "application/json")
    public OrderDto getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PostMapping(value = "/{clientId}", produces = "application/json", consumes = "application/json")
    public OrderDto postOrder(@PathVariable Long clientId, @RequestBody List<ItemDto> itemDtoList) throws InstanceNotFoundException {
        if(userService.getById(clientId).isEmpty()){
            throw new InstanceNotFoundException("Client was not found!");
        }
        else{
             return orderService.saveOrder(userService.getById(clientId).get(), itemDtoList);
        }
    }
}
