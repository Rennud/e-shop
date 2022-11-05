package com.example.eshopbackend.controller;

import com.example.eshopbackend.pojo.Category;
import com.example.eshopbackend.pojo.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api")
public interface ItemController {

    @GetMapping(value = "/item/{id}", produces = "application/json")
    Item getItemById(@PathVariable long id);

    @GetMapping(value = "/item/{size}/{page}", produces = "application/json")
    List<Item> getItemList(@PathVariable int size, @PathVariable int page);

    @GetMapping(value = "/category/{id}", produces = "application/json")
    Category getCategoryById(@PathVariable long id);

    @GetMapping(value = "/category/name/{name}", produces = "application/json")
    Category getCategoryByName(@PathVariable String name);

    @GetMapping(value = "/category/{size}/{page}", produces = "application/json")
    List<Category> getCategoryList(@PathVariable int size, @PathVariable int page);


}
