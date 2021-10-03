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
    public String getAds() throws JsonProcessingException {
        List<User> listUsers = userService.listAll();
        ObjectMapper mapper = new ObjectMapper();
        String users = mapper.writeValueAsString(listUsers);
        return users;
    }

    @GetMapping("/get/")
    public String getUser(@Param("id") Long id) throws JsonProcessingException {
        User user = userService.get(id);
        ObjectMapper mapper = new ObjectMapper();
        String userStr= mapper.writeValueAsString(user);
        return userStr;
    }

    @DeleteMapping("/del/")
    public boolean deleteAd( @Param("id") Long id) {
        userService.delete(id);
        return true;
    }

    @PostMapping("/add/")
    public void addUserById(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("/upd/")
    public void updUserById(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(json,User.class);
        userService.save(user);
    }

}

