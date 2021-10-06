package ru.simbrsoft.toysstore.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import ru.simbrsoft.toysstore.entity.User;
import ru.simbrsoft.toysstore.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getUsers() throws JsonProcessingException {
        return userService.listAll();
    }

    @GetMapping("/get/")
    public User getUser(@Param("id") Long id) throws JsonProcessingException {
        return userService.get(id);
    }

    @DeleteMapping("/del/")
    public boolean deleteAd( @Param("id") Long id) {
        userService.delete(id);
        return true;
    }

    @PostMapping("/add/")
    public void addUserById(@RequestBody User user) throws JsonProcessingException {
        userService.save(user);
    }

    @GetMapping("/upd/")
    public void updUserById(User user) throws JsonProcessingException {
        userService.save(user);
    }

}

