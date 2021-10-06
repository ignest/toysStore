package ru.simbrsoft.toysstore.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import ru.simbrsoft.toysstore.entity.ItemCategory;
import ru.simbrsoft.toysstore.service.ItemCategoryService;

import java.util.List;

@RestController
@RequestMapping("/itemCategoriess")
public class ItemCategoryController {
    @Autowired
    private ItemCategoryService itemCategoriesService;

    @GetMapping("")
    public List<ItemCategory> getItemCategories(){
        return itemCategoriesService.listAll();
    }

    @GetMapping("/get/")
    public ItemCategory getItemCategory(@Param("id") Long id) throws JsonProcessingException {
        return itemCategoriesService.get(id);
    }

    @DeleteMapping("/del/")
    public boolean deleteItemCategory( @Param("id") Long id) {
        itemCategoriesService.delete(id);
        return true;
    }

    @PostMapping("/add/")
    public void addItemCategoryById(@RequestBody ItemCategory itenCategories) {
        itemCategoriesService.save(itenCategories);
    }

    @GetMapping("/upd/")
    public void updItemCategoryById(ItemCategory itemCategories) throws JsonProcessingException {
        itemCategoriesService.save(itemCategories);
    }

}

