package com.example.eshopbackend.service;

import com.example.eshopbackend.dto.ItemDto;
import com.example.eshopbackend.dto.OrderDto;
import com.example.eshopbackend.entity.Item;
import com.example.eshopbackend.entity.Order;
import com.example.eshopbackend.entity.User;
import com.example.eshopbackend.exception.NotValidInputException;
import com.example.eshopbackend.mapper.ItemMapper;
import com.example.eshopbackend.mapper.OrderMapper;
import com.example.eshopbackend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;

    private final ItemService itemService;

    private final ItemMapper itemMapper;

    private final OrderMapper orderMapper;

    /**
     * Gets list of Entities from DB from Dto List
     *
     * @param itemDtoList list of Dtos
     * @return List of Entities
     */
    public List<Item> fetchItemsFromDB(List<ItemDto> itemDtoList) {
        return itemDtoList.stream()
                .map(ItemDto::id)
                .map(itemService::getItem)
                .toList();
    }

    /**
     * Gets Order from DB based on id
     *
     * @param id of Order
     * @return Order as Dto
     */
    @Transactional
    public OrderDto getOrderById(long id) {
        if (orderRepository.findById(id).isEmpty()) {
            throw new NotValidInputException("Id of order was not found");
        }
        return orderMapper.toDto(orderRepository.findById(id).get());
    }

    /**
     * Simple method for counting total price
     *
     * @param itemList list of Items from order
     * @return total price
     */
    public double countTotalPrice(List<Item> itemList) {
        return itemList.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }

    /**
     * Takes user and List of items. First fetch items from DB,
     * then checks if all items are in NOT sold state. If they are,
     * then creates new Order and update items in DB.
     * <p>
     * Tried to implement exception handling, but it broke whole thing.
     * Probably need to implement Jersey instead of Tomcat.
     *
     * @param user        that is making order
     * @param itemDtoList list of Items in order
     * @return so far Response, but not working
     */
    @Transactional
    public OrderDto saveOrder(User user, List<ItemDto> itemDtoList) {

        List<Item> itemList = fetchItemsFromDB(itemDtoList);

        if (itemService.validItems(itemList)) {
            // Removed builder during debugging DB connection. To scared to put it back
            Order order = new Order();
            order.setQuantity(itemDtoList.size());
            order.setItemList(itemList);
            order.setTotalPrice(countTotalPrice(itemList));
            order.setUser(user);

            itemService.updateItems(itemList, order);

            orderRepository.save(order);

            return orderMapper.toDto(order);
        }
        throw new NotValidInputException("One or more items in order was already sold");
    }
}
