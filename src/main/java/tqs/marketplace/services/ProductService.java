package tqs.marketplace.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import tqs.marketplace.entities.Product;
import tqs.marketplace.repositories.ProductRepository;

import java.util.*;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
        this.saveProducts();
    }

    public boolean saveProducts() {
        // save a few products
        this.repository.save(new Product(
                "8GB RAM for Mac",
                "2x4 GB RAM slots for Mac",
                90.00,
                "https://i.imgur.com/QI7ahI5.jpg"));
        this.repository.save(new Product(
                "4GB RAM Kingston",
                "2x2 GB RAM slots Kingston.jpg",
                50.00,
                "https://i.imgur.com/QI7ahI5.jpg"));
        this.repository.save(new Product(
                "1TB SSD WD SATA",
                "Solid state drive of 1TB Western Digital SATA",
                220.00,
                "https://i.imgur.com/gU1UV63.jpg"));
        this.repository.save(new Product(
                "512GB SSD Kingston",
                "Solid state drive of 512GB Kingston.jpg",
                129.99,
                "https://i.imgur.com/gU1UV63.jpg"));
        return true;
    }

    public boolean saveProduct(String name, String description, double price, String picturePath) {
        this.repository.save(new Product(name, description, price, picturePath));
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
        List<Product> retList = new ArrayList<Product>();

        // fetch all products
        for (Product product : repository.findAll()) {
            retList.add(product);
        }
        return retList;
    }

    public List<Product> findByName(String partialName){
        List<Product> retList = new ArrayList<Product>();

        // fetch a list of products by partialName
        for (Product product : repository.findByNameContaining(partialName)) {
            retList.add(product);
        }
        return retList;
    }

    public Product findById(long id){
        // fetch an individual product by ID
        Product product = repository.findById(id);
        System.out.println(product.toString());
        return product;
    }

}
