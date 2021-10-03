package ru.simbrsoft.toysstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.simbrsoft.toysstore.entity.User;
import ru.simbrsoft.toysstore.repo.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public void save(User user) {
        repo.save(user);
    }

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public User get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
