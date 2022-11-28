package com.example.eshopbackend.repository;

import com.example.eshopbackend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByCategory(String category);

    @Query(value = "SELECT * FROM item_table i WHERE i.sold = FALSE",
            nativeQuery = true)
    List<Item> findAllNotSold();
}
