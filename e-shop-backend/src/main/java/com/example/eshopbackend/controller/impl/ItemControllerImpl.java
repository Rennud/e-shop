package com.example.eshopbackend.controller.impl;


import com.example.eshopbackend.controller.inter.ItemController;
import com.example.eshopbackend.entity.Item;
import com.example.eshopbackend.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ItemControllerImpl implements ItemController {

    private final ItemService itemService;

    /**
     * Method for getting Item  by its id
     *
     * @param id of Item
     * @return requested Item
     */
    @Override
    public Item getItemById(long id) {
        return itemService.getItem(id);
    }

    /**
     * Method that returns list of given size and given page.
     *
     * @param size of page
     * @param page number of page
     * @return List of Items
     */
    @Override
    public List<Item> getItemList(int size, int page) {
        return itemService.getItemList(size, page);
    }

}
