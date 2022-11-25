package com.example.eshopbackend.controller.inter;

import com.example.eshopbackend.dto.ItemDto;
import com.example.eshopbackend.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/order")
public interface OrderController {

    @GetMapping(value = "/{id}", produces = "application/json")
    public OrderDto getOrderById(@PathVariable Long id);


    @PostMapping(value = "/{userId}", produces = "application/json", consumes = "application/json")
    public OrderDto postOrder(@PathVariable Long userId, @RequestBody List<ItemDto> itemDtoList);

    @PostMapping(value = "/token", produces = "application/json", consumes = "application/json")
    public OrderDto postOrderWithToken(@RequestHeader(name = "Authorization") String token, @RequestBody List<ItemDto> itemDtoList);

}
