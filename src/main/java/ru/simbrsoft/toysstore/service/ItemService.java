package ru.simbrsoft.toysstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.simbrsoft.toysstore.entity.Item;
import ru.simbrsoft.toysstore.repo.ItemRepository;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository repo;

    public void save(Item item) {
        repo.save(item);
    }

    public List<Item> listAll() {
        return (List<Item>) repo.findAll();
    }

    public Item get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
