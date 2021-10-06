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
    public List<Item> getAds() {
        return itemService.listAll();
    }

    @GetMapping("/get/")
    public Item getItem(@Param("id") Long id) {
        return itemService.get(id);
    }

    @DeleteMapping("/del/")
    public boolean deleteAd(@Param("id") Long id) {
        itemService.delete(id);
        return true;
    }

    @PostMapping("/add/")
    public void addItemById(@RequestBody Item item) {
        itemService.save(item);
    }

    @GetMapping("/upd/")
    public void updItemById(Item item) throws JsonProcessingException {
        itemService.save(item);
    }

}

