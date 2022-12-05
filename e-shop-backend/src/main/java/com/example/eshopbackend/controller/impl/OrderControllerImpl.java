package com.example.eshopbackend.controller.impl;

import com.example.eshopbackend.controller.inter.OrderController;
import com.example.eshopbackend.dto.ItemDto;
import com.example.eshopbackend.dto.OrderDto;
import com.example.eshopbackend.entity.User;
import com.example.eshopbackend.exception.NotValidInputException;
import com.example.eshopbackend.service.EmailService;
import com.example.eshopbackend.service.OrderService;
import com.example.eshopbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/order")
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;

    private final UserService userService;

    private final EmailService emailService;

    /**
     * GET method that returns OrderDto based on its id.<p>
     * localhost:8080/api/order/1
     *
     * @param id of OrderDto
     * @return Dto
     */
    @Override
    public OrderDto getOrderById(Long id) {
        return orderService.getOrderById(id);
    }

    /**
     * POST method for handling incoming orders.
     * localhost:8080/api/order/1
     *
     * @param userId      id of User
     * @param itemDtoList list of ordered items, it is enough to send objects only with ids.
     * @return OrderDto if successful
     * @throws NotValidInputException if any of the item has been sold before purchase.
     */
    @Override
    public OrderDto postOrder(Long userId, List<ItemDto> itemDtoList) throws NotValidInputException {
        return orderService.saveOrder(userService.getById(userId), itemDtoList);

    }

    /**
     * POST method for handling incoming orders with token in header
     * localhost:8080/api/order/token
     *
     * @param token       token from header
     * @param itemDtoList list of ordered items, it is enough to send objects only with ids.
     * @return OrderDto if successful
     * @throws NotValidInputException if any of the item has been sold before purchase.
     */
    @Override
    public OrderDto postOrderWithToken(String token, List<ItemDto> itemDtoList) {

        User user = userService.getUserFromToken(token);

        OrderDto orderDto = orderService.saveOrder(user, itemDtoList);

        emailService.sendConfirmationEmail(orderDto);

        return orderDto;
    }

}
