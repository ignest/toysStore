package ru.simbrsoft.toysstore.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.simbrsoft.toysstore.entity.Storage;

@Repository
public interface StorageRepository extends CrudRepository<Storage, Long> {
}
