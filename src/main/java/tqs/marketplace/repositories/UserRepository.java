package tqs.marketplace.repositories;

import org.springframework.data.repository.CrudRepository;
import tqs.marketplace.entities.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String LastName);
    User findById(long id);


}