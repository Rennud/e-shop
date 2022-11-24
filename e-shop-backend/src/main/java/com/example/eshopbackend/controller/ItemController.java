package com.example.eshopbackend.controller;

import com.example.eshopbackend.entity.Item;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path = "/api")
public interface ItemController {

    @GetMapping(value = "/item/{id}", produces = "application/json")
    Item getItemById(@PathVariable long id);

    @GetMapping(value = "/item/{size}/{page}", produces = "application/json")
    List<Item> getItemList(@PathVariable int size, @PathVariable int page);



}
