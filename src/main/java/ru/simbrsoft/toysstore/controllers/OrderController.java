package ru.simbrsoft.toysstore.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import ru.simbrsoft.toysstore.entity.Order;
import ru.simbrsoft.toysstore.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<Order> getAds() throws JsonProcessingException {
        return orderService.listAll();
    }

    @GetMapping("/get/")
    public Order getOrder(@Param("id") Long id) throws JsonProcessingException {
        return orderService.get(id);
    }

    @DeleteMapping("/del/")
    public boolean deleteAd( @Param("id") Long id) {
        orderService.delete(id);
        return true;
    }

    @PostMapping("/add/")
    public void addOrderById(@RequestBody Order order) {
        orderService.save(order);
    }

    @GetMapping("/upd/")
    public void updOrderById(Order order) throws JsonProcessingException {
        orderService.save(order);
    }

}

