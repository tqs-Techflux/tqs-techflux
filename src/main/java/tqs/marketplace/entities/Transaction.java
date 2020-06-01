package tqs.marketplace.entities;

import javax.persistence.*;
import java.lang.reflect.Type;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private User buyer;
    @ManyToOne
    private User seller;
    @OneToOne
    private Product product;

    protected Transaction(){}

    public Transaction(User buyer, User seller, Product product){
        this.buyer = buyer;
        this.seller = seller;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product productID) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", product=" + product +
                '}';
    }
}
