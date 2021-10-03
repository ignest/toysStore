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
    public String getAds() throws JsonProcessingException {
        List<OrderDetail> listOrderDetails = orderDetailService.listAll();
        ObjectMapper mapper = new ObjectMapper();
        String orderDetails = mapper.writeValueAsString(listOrderDetails);
        return orderDetails;
    }

    @GetMapping("/get/")
    public String getOrderDetail(@Param("id") Long id) throws JsonProcessingException {
        OrderDetail orderDetail = orderDetailService.get(id);
        ObjectMapper mapper = new ObjectMapper();
        String orderDetailStr= mapper.writeValueAsString(orderDetail);
        return orderDetailStr;
    }

    @DeleteMapping("/del/")
    public boolean deleteAd( @Param("id") Long id) {
        orderDetailService.delete(id);
        return true;
    }

    @PostMapping("/add/")
    public void addOrderDetailById(@RequestBody OrderDetail orderDetail) {
        orderDetailService.save(orderDetail);
    }

    @GetMapping("/upd/")
    public void updOrderDetailById(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        OrderDetail orderDetail = mapper.readValue(json,OrderDetail.class);
        orderDetailService.save(orderDetail);
    }

}

