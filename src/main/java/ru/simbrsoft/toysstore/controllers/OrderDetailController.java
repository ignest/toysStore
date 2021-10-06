package ru.simbrsoft.toysstore.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import ru.simbrsoft.toysstore.entity.OrderDetail;
import ru.simbrsoft.toysstore.service.OrderDetailService;

import java.util.List;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("")
    public List<OrderDetail> getOrderDetails() throws JsonProcessingException {
        return orderDetailService.listAll();
    }

    @GetMapping("/get/")
    public OrderDetail getOrderDetail(@Param("id") Long id) throws JsonProcessingException {
        return orderDetailService.get(id);
    }

    @DeleteMapping("/del/")
    public boolean deleteAd(@Param("id") Long id) {
        orderDetailService.delete(id);
        return true;
    }

    @PostMapping("/add/")
    public void addOrderDetailById(@RequestBody OrderDetail orderDetail) {
        orderDetailService.save(orderDetail);
    }

    @GetMapping("/upd/")
    public void updOrderDetailById(OrderDetail orderDetail) throws JsonProcessingException {
        orderDetailService.save(orderDetail);
    }

}

