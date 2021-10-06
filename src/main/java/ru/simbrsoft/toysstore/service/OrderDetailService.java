package ru.simbrsoft.toysstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.simbrsoft.toysstore.entity.OrderDetail;
import ru.simbrsoft.toysstore.repo.OrderDetailRepository;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    OrderDetailRepository repo;

    public void save(OrderDetail orderDetail) {
        repo.save(orderDetail);
    }

    public List<OrderDetail> listAll() {
        return (List<OrderDetail>) repo.findAll();
    }

    public OrderDetail get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
