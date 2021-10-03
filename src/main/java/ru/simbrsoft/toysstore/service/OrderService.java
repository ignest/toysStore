package ru.simbrsoft.toysstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.simbrsoft.toysstore.entity.Order;
import ru.simbrsoft.toysstore.repo.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository repo;

    public void save(Order order) {
        repo.save(order);
    }

    public List<Order> listAll() {
        return (List<Order>) repo.findAll();
    }

    public Order get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
