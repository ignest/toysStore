package ru.simbrsoft.toysstore.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public String getAds() throws JsonProcessingException {
        List<Order> listOrders = orderService.listAll();
        ObjectMapper mapper = new ObjectMapper();
        String orders = mapper.writeValueAsString(listOrders);
        return orders;
    }

    @GetMapping("/get/")
    public String getOrder(@Param("id") Long id) throws JsonProcessingException {
        Order order = orderService.get(id);
        ObjectMapper mapper = new ObjectMapper();
        String orderStr= mapper.writeValueAsString(order);
        return orderStr;
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
    public void updOrderById(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.readValue(json,Order.class);
        orderService.save(order);
    }

}

