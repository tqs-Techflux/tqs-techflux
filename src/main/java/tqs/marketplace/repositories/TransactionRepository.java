package tqs.marketplace.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tqs.marketplace.entities.Transaction;

import java.util.List;


@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findByBuyer(long buyerId);
    List<Transaction> findBySeller(long sellerId);
}
