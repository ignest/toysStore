package ru.simbrsoft.toysstore.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.simbrsoft.toysstore.entity.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
