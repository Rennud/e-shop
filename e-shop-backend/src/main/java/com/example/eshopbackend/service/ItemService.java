package com.example.eshopbackend.service;

import com.example.eshopbackend.entity.Item;
import com.example.eshopbackend.entity.Order;
import com.example.eshopbackend.exception.NotValidInputException;
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
     *
     * @param id of Item
     * @return requested Item
     */
    @Transactional
    public Item getItem(long id) {
        if (itemRepository.findById(id).isEmpty()) {
            throw new NotValidInputException("Id of Item not found!");
        }
        return itemRepository.findById(id).get();
    }

    /**
     * Method that returns list of given size and given page.
     *
     * @param size of page
     * @param page number of page
     * @return List of Items
     */
    @Transactional
    public List<Item> getItemList(int size, int page) {
        if (!itemRepository.findAll().isEmpty()) {
            return itemRepository.findAll().stream()
                    .skip((long) size * page)
                    .limit(size)
                    .toList();
        }
        throw new NotValidInputException("List of items is empty!");
    }

    /**
     * Simple setter that returns updated object
     *
     * @param item that needs to be updated
     * @return updated Item
     */
    public Item changeStateToSold(Item item) {
        item.setSold(true);
        return item;
    }

    /**
     * Simple setter that returns updated object
     *
     * @param item  that needs to be updated
     * @param order that will be new attribute
     * @return updated Item
     */
    public Item setOrder(Item item, Order order) {
        item.setOrder(order);
        return item;
    }

    /**
     * Gets proxy entity from DB based on real entity.<p>
     * Used in JPA as way to update Entities.<p>
     * More in Interface JpaRepository documentation.
     *
     * @param item Entity that needs to be updated
     * @return a reference to the entity with the given identifier
     */
    public Item getReference(Item item) {
        return itemRepository.getReferenceById(item.getId());
    }

    /**
     * Method for updating Items in DB.<p>
     * Changes state to sold and adds reference to Order.<p>
     * First gets references based on Entities,
     * then change their states and saves them to List.<p>
     * As last saves changed entities in DB.
     *
     * @param itemList List of items that needs to be changed
     * @param order    order that will be new attribute of Items in List
     * @return List of updated Items
     */
    public List<Item> updateItems(List<Item> itemList, Order order) {
        List<Item> updatedItems = itemList.stream()
                .map(this::getReference)
                .map(this::changeStateToSold)
                .map(i -> setOrder(i, order))
                .toList();

        updatedItems.forEach(itemRepository::save);
        return updatedItems;
    }

    /**
     * Checks if any of the Items has been already sold.
     *
     * @param itemList List that needs to be checked
     * @return true if NO Item has been already sold.
     * False if ANY Item has been already sold.
     */
    public boolean validItems(List<Item> itemList) {
        return itemList.stream()
                .allMatch(item -> !item.isSold());
    }

}
