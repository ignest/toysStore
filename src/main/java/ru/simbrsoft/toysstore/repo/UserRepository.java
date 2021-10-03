package ru.simbrsoft.toysstore.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.simbrsoft.toysstore.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
