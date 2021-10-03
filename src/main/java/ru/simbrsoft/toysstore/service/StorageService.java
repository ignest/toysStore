package ru.simbrsoft.toysstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.simbrsoft.toysstore.entity.Storage;
import ru.simbrsoft.toysstore.repo.StorageRepository;

import java.util.List;

@Service
public class StorageService {

    @Autowired
    StorageRepository repo;

    public void save(Storage storage) {
        repo.save(storage);
    }

    public List<Storage> listAll() {
        return (List<Storage>) repo.findAll();
    }

    public Storage get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
