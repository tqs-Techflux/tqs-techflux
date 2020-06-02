package tqs.marketplace.services;

import org.springframework.stereotype.Service;
import tqs.marketplace.entities.Category;
import tqs.marketplace.entities.Product;
import tqs.marketplace.entities.User;
import tqs.marketplace.repositories.ProductRepository;

import java.util.*;

@Service
public class ProductService {
    private ProductRepository repository;

    protected ProductService(){}

    public ProductService(ProductRepository repository){
        this.repository = repository;
        this.saveProducts();
    }

    public boolean saveProducts() {
        Category c1 = new CategoryService().findByName("Components");
        Category c2 = new CategoryService().findByName("Computers");
        Category c3 = new CategoryService().findByName("Mobile Devices");

        User u1 = new UserService().findById(0);
        User u2 = new UserService().findById(2);

        // save a few products
        Product p1 = new Product(
                "8GB RAM for Mac",
                "2x4 GB RAM slots for Mac",
                90.00,
                "https://i.imgur.com/QI7ahI5.jpg")
                ;
        Product p2 = new Product(
                "4GB RAM Kingston",
                "2x2 GB RAM slots Kingston.jpg",
                50.00,
                "https://i.imgur.com/QI7ahI5.jpg");
        Product p3 = new Product(
                "1TB SSD WD SATA",
                "Solid state drive of 1TB Western Digital SATA",
                220.00,
                "https://i.imgur.com/gU1UV63.jpg");
        Product p4 = new Product(
                "512GB SSD Kingston",
                "Solid state drive of 512GB Kingston.jpg",
                129.99,
                "https://i.imgur.com/gU1UV63.jpg");

        p1.setOwner(u1); p1.setCategory(c1);
        p2.setOwner(u2); p2.setCategory(c1);
        p3.setOwner(u1); p3.setCategory(c1);
        p4.setOwner(u2); p4.setCategory(c1);

        this.repository.save(p1);
        this.repository.save(p2);
        this.repository.save(p3);
        this.repository.save(p4);

        return true;
    }

    // without user and category
    public boolean saveProduct(String name, String description, double price, String picturePath) {
        this.repository.save(new Product(name, description, price, picturePath));
        return true;
    }

    // with owner and category (String)
    public boolean saveProduct(String name, String description, double price, String picturePath, long ownerId, String catName) {
        User owner = new UserService().findById(ownerId);
        Category cat = new CategoryService().findByName(catName);
        this.repository.save(new Product(name, description, price, picturePath, owner, cat));
        return true;
    }

    // with owner and category (long)
    public boolean saveProduct(String name, String description, double price, String picturePath, long ownerId, long catId) {
        User owner = new UserService().findById(ownerId);
        Category cat = new CategoryService().findById(catId);
        this.repository.save(new Product(name, description, price, picturePath, owner, cat));
        return true;
    }

    public boolean updateProduct(Product p, String name, String description, double price, String picturePath) {
        p.setName(name);
        p.setDescription(description);
        p.setPrice(price);
        p.setPicture(picturePath);
        this.repository.save(p);
        return true;
    }

    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    public List<Product> findByName(String partialName){
        return (List<Product>) repository.findByNameContaining(partialName);
    }

    public Product findById(long id){
        return (Product) repository.findById(id);
    }

}
