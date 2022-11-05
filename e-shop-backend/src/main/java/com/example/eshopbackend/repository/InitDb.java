package com.example.eshopbackend.repository;

import com.example.eshopbackend.pojo.Category;
import com.example.eshopbackend.pojo.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final Random random = new Random();

    private final DummyItemRepository dummyItemRepository;

    private final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    /**
     * Method for generating random prices
     * @param lowestIncluded lowest generated price
     * @param highestExcluded highest generated price EXCLUDED
     * @return random price
     */
    public double getRandomPrice(double lowestIncluded, double highestExcluded){
        BigDecimal bigDecimal = BigDecimal.valueOf(random.nextDouble(lowestIncluded,highestExcluded));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);

        return bigDecimal.doubleValue();
    }

    /**
     * Method for determining category based on price
     * @param price price of Item
     * @return name of Category
     */
    public String nameOfCategory(double price) throws IOException {

        if (price <= 5.0){
            return "cheap";
        }
        if(price <= 10){
            return "fair price";
        }
        if(price > 10){
            return "expensive";
        }
        throw new IOException("Out of range");
    }

    /**
     * Method for generating random price between 0.00 to 15.99
     * @return price rounded to two decimals
     */
    public double getRandomPrice(){
        BigDecimal bigDecimal = BigDecimal.valueOf(random.nextDouble(0.0,16.0));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    /**
     * Generate random name of coffee
     * @return random name of coffee
     */
    public String getRandomNameOfItem(){
        List<String> adjectives = List.of("Delicious","Strange","Great", "Hot");
        List<String> nouns = List.of(" Brazil", " Kenya", " Ethiopia", " Burundi");

        int randomAdjective = random.nextInt(4);
        int randomNoun = random.nextInt(4);

        return adjectives.get(randomAdjective) + nouns.get(randomNoun);
    }

    /**
     * Generates random item with defined price range
     * @param lowestIncluded lowest possible price
     * @param highestExcluded highest possible price EXCLUDED
     * @return
     */
    public Item makeRandomItemWithDefinedPrice(double lowestIncluded, double highestExcluded){
        return Item.builder()
                .name(this.getRandomNameOfItem())
                .price(this.getRandomPrice(lowestIncluded,highestExcluded))
                .build();
    }

    /**
     * Generates random Item with price between 0.00 to 15.99
     * @return random Item
     */
    public Item makeRandomItem(){
        return Item.builder()
                .name(this.getRandomNameOfItem())
                .price(this.getRandomPrice())
                .build();
    }

    /**
     * Generates random list of Items with prices between 0.00 to 15.99
     * @param size
     * @return
     */
    public List<Item> makeListOfRandomItems(long size){
        List<Item> itemList = LongStream.range(1L,size)
                .mapToObj(i -> makeRandomItem())
                .toList();

        LongStream.range(1L, size)
                .forEach(i-> itemList.get((int) i -1).setId(i));

        return itemList;

    }

    /**
     * Create dummy Category with name cheap
     * @param sizeOfItemsArray size of Category listOfItems
     * @return
     */
    public Category makeCheapCategory(long sizeOfItemsArray){
        List<Item> itemList = LongStream.range(0, sizeOfItemsArray)
                .mapToObj(i -> makeRandomItemWithDefinedPrice(0.0,4.9))
                .toList();
        return Category.builder().id(0).name("cheap").itemList(itemList).build();
        }

    /**
     * Fills dummy DB with random data with size 10
     */
    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        dummyItemRepository.putItemsInList(makeListOfRandomItems(10L));
        dummyItemRepository.setCategory(makeCheapCategory(10L));
    }
}
