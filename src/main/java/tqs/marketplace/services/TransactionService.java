package tqs.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tqs.marketplace.entities.Product;
import tqs.marketplace.entities.Transaction;
import tqs.marketplace.entities.User;
import tqs.marketplace.repositories.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;
    @Autowired
    private ProductService ps;
    @Autowired
    private UserService us;

    protected TransactionService(){}

    public TransactionService(TransactionRepository repository){
        this.repository = repository;
    }

    public boolean saveTransaction(long buyerId, long sellerId, long productId){
        User buyer = this.us.findById(buyerId);
        User seller = this.us.findById(sellerId);
        Product product = this.ps.findById(productId);

        this.repository.save(new Transaction(buyer, seller, product));
        return true;
    }

    public Transaction findByUserById(long userId, long transactionId){
        for (Transaction t : findByUser(userId)) {
            if (t.getId() == (transactionId))
                return t;
        }
        return null;
    }

    public List<Transaction> findByUser(long userId){
        List<Transaction> retList = new ArrayList<Transaction>();
        retList.addAll((List<Transaction>) repository.findByBuyer(userId));
        retList.addAll((List<Transaction>) repository.findBySeller(userId));
        return retList;
    }
}
