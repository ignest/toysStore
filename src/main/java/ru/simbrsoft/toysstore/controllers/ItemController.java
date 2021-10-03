package ru.simbrsoft.toysstore.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import ru.simbrsoft.toysstore.entity.Item;
import ru.simbrsoft.toysstore.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("")
    public String getAds() throws JsonProcessingException {
        List<Item> listItems = itemService.listAll();
        ObjectMapper mapper = new ObjectMapper();
        String items = mapper.writeValueAsString(listItems);
        return items;
    }

    @GetMapping("/get/")
    public String getItem(@Param("id") Long id) throws JsonProcessingException {
        Item item = itemService.get(id);
        ObjectMapper mapper = new ObjectMapper();
        String itemStr= mapper.writeValueAsString(item);
        return itemStr;
    }

    @DeleteMapping("/del/")
    public boolean deleteAd( @Param("id") Long id) {
        itemService.delete(id);
        return true;
    }

    @PostMapping("/add/")
    public void addItemById(@RequestBody Item item) {
        itemService.save(item);
    }

    @GetMapping("/upd/")
    public void updItemById(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Item item = mapper.readValue(json,Item.class);
        itemService.save(item);
    }

}

