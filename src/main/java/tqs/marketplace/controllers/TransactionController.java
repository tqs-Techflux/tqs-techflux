package tqs.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tqs.marketplace.entities.Transaction;
import tqs.marketplace.services.TransactionService;

import java.util.List;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;


    @GetMapping("/{userId}/all")
    public ResponseEntity<List<Transaction>> searchByUser(@PathVariable("userId") long id){
        return new ResponseEntity<List<Transaction>>(transactionService.findByUser(id), HttpStatus.OK);
    }

    @GetMapping("/{userId}/id/{transactionId}")
    public ResponseEntity<Transaction> searchByUserById(@PathVariable("userId") long userId, @PathVariable("transactionId") long transactionId){
        return new ResponseEntity<Transaction>(transactionService.findByUserById(userId, transactionId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> addTransaction(long buyerId, long sellerId, long productId){
        return new ResponseEntity<Boolean>(transactionService.saveTransaction(
                buyerId,
                sellerId,
                productId
        ), HttpStatus.OK);
    }
}
