package ru.simbrsoft.toysstore.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import ru.simbrsoft.toysstore.entity.Storage;
import ru.simbrsoft.toysstore.service.StorageService;

import java.util.List;

@RestController
@RequestMapping("/storages")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @GetMapping("")
    public List<Storage> getStorages() throws JsonProcessingException {
        return storageService.listAll();
    }

    @GetMapping("/get/")
    public Storage getStorage(@Param("id") Long id) throws JsonProcessingException {
        return storageService.get(id);
    }

    @DeleteMapping("/del/")
    public boolean deleteStorage(@Param("id") Long id) {
        storageService.delete(id);
        return true;
    }

    @PostMapping("/add/")
    public void addStorageById(@RequestBody Storage storage) {
        storageService.save(storage);
    }

    @GetMapping("/upd/")
    public void updStorageById(Storage storage) throws JsonProcessingException {
        storageService.save(storage);
    }

}

