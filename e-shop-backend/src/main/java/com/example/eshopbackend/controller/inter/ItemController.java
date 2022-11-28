package com.example.eshopbackend.controller.inter;

import com.example.eshopbackend.entity.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api/item")
public interface ItemController {

    @GetMapping(value = "/id/{id}", produces = "application/json")
    Item getItemById(@PathVariable long id);

    @GetMapping(value = "/page/{size}/{page}", produces = "application/json")
    List<Item> getItemListPage(@PathVariable int size, @PathVariable int page);

    @GetMapping(value = "/all", produces = "application/json")
    List<Item> getItemListAll();

    @GetMapping(value = "/all/not_sold", produces = "application/json")
    List<Item> getItemListNotSold();

    @GetMapping(value = "/category/{category}", produces = "application/json")
    List<Item> getCategory(@PathVariable String category);


}
