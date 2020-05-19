package tqs.marketplace.services;

import org.springframework.stereotype.Service;
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
        this.repository.save(new Product("8GB RAM", "2x4 GB RAM slots", 130.00));
        this.repository.save(new Product("1TB SSD", "Solid state drive of 1TB", 400.00));
        return true;
    }

    public boolean saveProduct(String name, String description, double price) {
        // save a few products
        this.repository.save(new Product(name, description, price));
        return true;
    }

    public List<Product> findAll() {
        List<Product> retList = new ArrayList<Product>();

        // fetch all products
        for (Product product : repository.findAll()) {
            retList.add(product);
            System.out.println(product.toString());
        }
        return retList;
    }

    public List<Product> findByName(String partialName){
        List<Product> retList = new ArrayList<Product>();

        // fetch a list of products by partialName
        for (Product product : repository.findByNameContaining(partialName)) {
            retList.add(product);
            System.out.println(product.toString());
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
