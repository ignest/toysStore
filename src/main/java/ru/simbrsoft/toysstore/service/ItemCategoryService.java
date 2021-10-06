package ru.simbrsoft.toysstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.simbrsoft.toysstore.entity.ItemCategory;
import ru.simbrsoft.toysstore.repo.ItemCategoryRepository;

import java.util.List;

@Service
public class ItemCategoryService {

    @Autowired
    ItemCategoryRepository repo;

    public void save(ItemCategory itemCategory) {
        repo.save(itemCategory);
    }

    public List<ItemCategory> listAll() {
        return (List<ItemCategory>) repo.findAll();
    }

    public ItemCategory get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
