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
    public String getAds() throws JsonProcessingException {
        List<Storage> listStorages = storageService.listAll();
        ObjectMapper mapper = new ObjectMapper();
        String storages = mapper.writeValueAsString(listStorages);
        return storages;
    }

    @GetMapping("/get/")
    public String getStorage(@Param("id") Long id) throws JsonProcessingException {
        Storage storage = storageService.get(id);
        ObjectMapper mapper = new ObjectMapper();
        String storageStr= mapper.writeValueAsString(storage);
        return storageStr;
    }

    @DeleteMapping("/del/")
    public boolean deleteAd( @Param("id") Long id) {
        storageService.delete(id);
        return true;
    }

    @PostMapping("/add/")
    public void addStorageById(@RequestBody Storage storage) {
        storageService.save(storage);
    }

    @GetMapping("/upd/")
    public void updStorageById(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Storage storage = mapper.readValue(json,Storage.class);
        storageService.save(storage);
    }

}

