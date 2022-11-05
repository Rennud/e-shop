package com.example.eshopbackend.service;

import com.example.eshopbackend.pojo.Category;
import com.example.eshopbackend.pojo.Item;
import com.example.eshopbackend.repository.DummyItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final DummyItemRepository dummyItemRepository;

    /**
     * Method for getting Item  by its id
     * @param id of Item
     * @return requested Item
     */
    public Item getItem(long id){
        return dummyItemRepository.getItemById(id);
    }
    /**
     * Method that returns list of given size and given page.
     * @param size of page
     * @param page number of page
     * @return List of Items
     */
    public List<Item> getItemList(int size, int page){
        return dummyItemRepository.getAllItems().stream()
                .skip((long) size * page)
                .limit(size)
                .toList();
    }

    /**
     * Dummy method, returns always same Category!
     * @param
     * @return
     */
    public Category getCategory(){
        return dummyItemRepository.getCategory();
    }


}
