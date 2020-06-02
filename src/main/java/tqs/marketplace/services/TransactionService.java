package tqs.marketplace.services;

import org.springframework.stereotype.Service;
import tqs.marketplace.entities.Product;
import tqs.marketplace.entities.Transaction;
import tqs.marketplace.entities.User;
import tqs.marketplace.repositories.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {
    private TransactionRepository repository;

    protected TransactionService(){}

    public TransactionService(TransactionRepository repository){
        this.repository = repository;
        this.saveTransactions();
    }

    public boolean saveTransactions(){
        UserService userService = new UserService();
        User buyer1 = userService.findById(1);
        User seller1 = userService.findById(0);
        Product p1 = new ProductService().findById(0);

        Transaction t1 = new Transaction(buyer1, seller1, p1);
        this.repository.save(t1);
        return true;
    }

    public boolean saveTransaction(long buyerId, long sellerId, long productId){
        UserService userService = new UserService();
        User buyer = userService.findById(buyerId);
        User seller = userService.findById(sellerId);
        Product product = new ProductService().findById(productId);

        this.repository.save(new Transaction(buyer, seller, product));
        return true;
    }

    public Transaction findByUserById(long userId, long transactionId){
        return (Transaction) repository.findByUserById(userId, transactionId);
    }

    public List<Transaction> findByUser(long userId){
        return (List<Transaction>) repository.findByUser(userId);
    }
}
