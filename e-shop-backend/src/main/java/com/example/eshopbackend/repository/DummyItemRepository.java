package com.example.eshopbackend.repository;

import com.example.eshopbackend.pojo.Category;
import com.example.eshopbackend.pojo.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DummyItemRepository {

    private List<Item> itemList = new ArrayList<>();

    private Category category;

    void putItemInList(Item item){
        this.itemList.add(item);
    }

    void putItemsInList(List<Item> items){
        this.itemList.addAll(items);
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public Item getItemById(long id){
        return itemList.get((int) id -1);
    }

    public Category getCategory (){
        return this.category;
    }

    public List<Item> getAllItems(){
        return this.itemList;
    }
}
