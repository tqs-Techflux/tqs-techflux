package tqs.marketplace.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import tqs.marketplace.entities.Product;
import tqs.marketplace.entities.Transaction;
import tqs.marketplace.entities.User;
import tqs.marketplace.repositories.TransactionRepository;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {


    @MockBean
    private TransactionService service;
    @MockBean
    private TransactionRepository repository;
    @MockBean
    private ProductService ps;
    @MockBean
    private UserService us;

    @BeforeEach
    void setUp(){
        this.service = new TransactionService();
    }

    @Test
    void saveTransactionTest() {
        User testBuyer = us.findById(0);
        User testSeller = us.findById(1);
        Product testProduct = ps.findById(0);
        Transaction testTransaction = new Transaction(testBuyer, testSeller,testProduct);
        service.saveTransaction(testBuyer.getId(), testSeller.getId(), testProduct.getId());
        assertTrue(service.findByUser(testBuyer.getId()).contains(testTransaction));
    }

    @Test
    void findByUserByIdTest() {
        User testBuyer = us.findById(0);
        User testSeller = us.findById(1);
        Product testProduct = ps.findById(0);
        Transaction testTransaction = new Transaction(testBuyer, testSeller,testProduct);
        service.saveTransaction(testBuyer.getId(), testSeller.getId(), testProduct.getId());
        assertEquals(testTransaction, service.findByUserById(testBuyer.getId(), 0));
    }

    @Test
    void findByUser() {
        User testBuyer = us.findById(0);
        User testSeller = us.findById(1);
        Product testProduct = ps.findById(0);
        Transaction testTransaction = new Transaction(testBuyer, testSeller,testProduct);
        service.saveTransaction(testBuyer.getId(), testSeller.getId(), testProduct.getId());
        assertTrue(service.findByUser(testBuyer.getId()).contains(testTransaction));
    }
}