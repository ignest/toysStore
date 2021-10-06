package ru.simbrsoft.toysstore.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.simbrsoft.toysstore.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
