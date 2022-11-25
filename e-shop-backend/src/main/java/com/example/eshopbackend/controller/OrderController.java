package com.example.eshopbackend.controller;

import com.example.eshopbackend.dto.ItemDto;
import com.example.eshopbackend.dto.OrderDto;
import com.example.eshopbackend.entity.User;
import com.example.eshopbackend.exception.NotValidInputException;
import com.example.eshopbackend.service.OrderService;
import com.example.eshopbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/order")
public class OrderController {

    private final OrderService orderService;

    private final UserService userService;

    /**
     * GET method that returns OrderDto based on its id.<p>
     * localhost:8080/api/order/1
     * @param id of OrderDto
     * @return Dto
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    public OrderDto getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    /**
     * POST method for handling incoming orders.
     * localhost:8080/api/order/1
     * @param userId id of User
     * @param itemDtoList list of ordered items, it is enough to send objects only with ids.
     * @return OrderDto if successful
     * @throws NotValidInputException if any of the item has been sold before purchase.
     */
    @PostMapping(value = "/{userId}", produces = "application/json", consumes = "application/json")
    public OrderDto postOrder(@PathVariable Long userId, @RequestBody List<ItemDto> itemDtoList) throws NotValidInputException {
        return orderService.saveOrder(userService.getById(userId), itemDtoList);

    }
    /**
     * POST method for handling incoming orders with token in header
     * localhost:8080/api/order/token
     * @param token token from header
     * @param itemDtoList list of ordered items, it is enough to send objects only with ids.
     * @return OrderDto if successful
     * @throws NotValidInputException if any of the item has been sold before purchase.
     */
    @PostMapping(value = "/token", produces = "application/json", consumes = "application/json")
    public OrderDto postOrderWithToken(@RequestHeader (name="Authorization") String token, @RequestBody List<ItemDto> itemDtoList){

        token = token.substring(6);
        User user = userService.getFromToken(token);

        System.out.println(user.getFirstName() + " " +user.getLastName());
        return orderService.saveOrder(user, itemDtoList);

    }

}
