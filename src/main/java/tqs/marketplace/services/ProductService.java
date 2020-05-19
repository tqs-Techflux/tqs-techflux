package tqs.marketplace.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tqs.marketplace.entities.Product;
import tqs.marketplace.repositories.ProductRepository;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(){
        this.saveProduct();
    }

    public boolean saveProduct() {
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

    public List<Product> findByName(String name){
        List<Product> retList = new ArrayList<Product>();

        // fetch an individual product by ID
        for (Product product : repository.findByName(name)) {
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
