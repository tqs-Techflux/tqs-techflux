package tqs.marketplace.repositories;

import org.springframework.data.repository.CrudRepository;
import tqs.marketplace.entities.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
    Product findById(long id);

    List<Product> findByTag(String tag);

}
