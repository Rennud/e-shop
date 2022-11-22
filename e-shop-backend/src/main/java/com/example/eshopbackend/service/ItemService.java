package com.example.eshopbackend.service;

import com.example.eshopbackend.entity.Item;
import com.example.eshopbackend.entity.Order;
import com.example.eshopbackend.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    /**
     * Method for getting Item  by its id
     * @param id of Item
     * @return requested Item
     */
    @Transactional
    public Item getItem(long id){
        if (itemRepository.findById(id).isPresent()){
            return (Item) itemRepository.findById(id).get();
        }
        throw new RuntimeException("Id of Item not found!");
    }

    /**
     * Method that returns list of given size and given page.
     *
     * @param size of page
     * @param page number of page
     * @return List of Items
     */
    @Transactional
    public List<Item> getItemList(int size, int page){
        if(!itemRepository.findAll().isEmpty()) {
            return itemRepository.findAll().stream()
                    .skip((long) size * page)
                    .limit(size)
                    .toList();
        }
        throw new RuntimeException("List of items is empty!");
    }

    /**
     * Dummy method, returns always same Category!
     * @param
     * @return
     */
//    public Category getCategory(){
//        return itemRepository.getCategory();
//    }



}
