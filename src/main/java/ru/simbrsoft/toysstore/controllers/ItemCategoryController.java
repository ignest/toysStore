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
@RequestMapping("/itenCategoriess")
public class ItemCategoryController {
    @Autowired
    private ItemCategoryService itenCategoriesService;

    @GetMapping("")
    public String getAds() throws JsonProcessingException {
        List<ItemCategory> listItemCategorys = itenCategoriesService.listAll();
        ObjectMapper mapper = new ObjectMapper();
        String itenCategoriess = mapper.writeValueAsString(listItemCategorys);
        return itenCategoriess;
    }

    @GetMapping("/get/")
    public String getItemCategory(@Param("id") Long id) throws JsonProcessingException {
        ItemCategory itenCategories = itenCategoriesService.get(id);
        ObjectMapper mapper = new ObjectMapper();
        String itenCategoriesStr= mapper.writeValueAsString(itenCategories);
        return itenCategoriesStr;
    }

    @DeleteMapping("/del/")
    public boolean deleteAd( @Param("id") Long id) {
        itenCategoriesService.delete(id);
        return true;
    }

    @PostMapping("/add/")
    public void addItemCategoryById(@RequestBody ItemCategory itenCategories) {
        itenCategoriesService.save(itenCategories);
    }

    @GetMapping("/upd/")
    public void updItemCategoryById(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ItemCategory itenCategories = mapper.readValue(json,ItemCategory.class);
        itenCategoriesService.save(itenCategories);
    }

}

