package tqs.marketplace.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tqs.marketplace.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstNameContaining(String partialName);
    List<User> findByLastNameContaining(String partialName);
    User findByEmail(String email);
    User findById(long id);

}