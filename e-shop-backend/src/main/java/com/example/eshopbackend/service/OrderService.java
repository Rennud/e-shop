package com.example.eshopbackend.service;

import com.example.eshopbackend.dto.ItemDto;
import com.example.eshopbackend.dto.OrderDto;
import com.example.eshopbackend.entity.Item;
import com.example.eshopbackend.entity.Order;
import com.example.eshopbackend.entity.User;
import com.example.eshopbackend.mapper.ItemMapper;
import com.example.eshopbackend.mapper.OrderMapper;
import com.example.eshopbackend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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


    public List<Item> fetchItemsFromDB(List<ItemDto> itemDtoList){
        return itemDtoList.stream()
                .map(ItemDto::id)
                .map(itemService::getItem)
                .toList();
    }
    @Transactional
    public OrderDto getOrderById(long id){
        if(orderRepository.findById(id).isEmpty()){
            throw new RuntimeException("Id not found");
        }
        Order order = orderRepository.findById(id).get();
        List<ItemDto> dtoList = itemMapper.toDto(order.getItemList());

        return orderMapper.toDto(orderRepository.findById(id).get());
    }

    public List<Item> changeStateToSold(List<Item> items){
        items.forEach(e-> e.setSold(true));
        return items;
    }

    public double countTotalPrice(List<Item> itemList){
        return itemList.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }

    @Transactional
    public OrderDto saveOrder(User user, List<ItemDto> itemDtoList){

        List<Item> itemList = fetchItemsFromDB(itemDtoList);

        Order order = new Order();

        order.setQuantity(itemDtoList.size());
        order.setItemList(itemList);
        order.setTotalPrice(countTotalPrice(itemList));
        order.setUser(user);

        itemService.updateItems(itemList,order);
        itemList.forEach(e-> log.info(e.toString() + "was updated in DB."));


        orderRepository.save(order);
        log.info(order + " was saved to DB.");

        return orderMapper.toDto(order);
    }
}
