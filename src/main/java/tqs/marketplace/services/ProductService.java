package tqs.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tqs.marketplace.entities.Category;
import tqs.marketplace.entities.Product;
import tqs.marketplace.entities.User;
import tqs.marketplace.repositories.ProductRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryService cs;
    @Autowired
    private UserService us;
    @Autowired
    private TransactionService ts;

    private Path root = Paths.get("src/main/resources/pictures");

    public void saveProducts() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            System.out.println("Picture path already exists");
        }
        // Temporary Category creation
        this.cs.saveCategories();
        // Temporary User creation
        this.us.saveUsers();

        Category c1 = this.cs.findByName("Components");
        Category c2 = this.cs.findByName("Computers");
        Category c3 = this.cs.findByName("Mobile Devices");

        User u1 = this.us.loadUserByEmail("joaoaz@gmail.com");
        User u2 = this.us.loadUserByEmail("vicorreia@gmail.com");
        User u3 = this.us.loadUserByEmail("testeves@gmail.com");

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

        p1.setOwner(u1); p1.setCategory(c1); this.repository.save(p1);
        p2.setOwner(u3); p2.setCategory(c1); this.repository.save(p2);
        p3.setOwner(u1); p3.setCategory(c1); this.repository.save(p3);
        p4.setOwner(u3); p4.setCategory(c1); this.repository.save(p4);

        this.ts.saveTransaction(u2.getId(), u1.getId(), p1.getId());
    }

    public String saveFile(MultipartFile file, String name){
        try {
            Files.copy(file.getInputStream(), this.root.resolve(name));
            return this.root.resolve(name).toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // with owner and categoryName
    public Product saveProduct(String name, String description, double price, String picturePath, long ownerId, String catName) {
        User owner = this.us.findById(ownerId);
        Category cat = this.cs.findByName(catName);
        return this.repository.save(new Product(name, description, price, picturePath, owner, cat));
    }

    public Product saveProduct(Product p){
        return this.repository.save(p);
    }

    // with owner and categoryId
    public boolean saveProduct(String name, String description, double price, String picturePath, long ownerId, long catId) {
        User owner = this.us.findById(ownerId);
        Category cat = this.cs.findById(catId);
        this.repository.save(new Product(name, description, price, picturePath, owner, cat));
        return true;
    }

    public boolean updateProduct(long id, String name, String description, double price, String picturePath) {
        Product p = this.repository.findById(id);
        p.setName(name);
        p.setDescription(description);
        p.setPrice(price);
        p.setPicture(picturePath);
        this.repository.save(p);
        return true;
    }

    public List<Product> findAll() {
        List <Product> prods = (List<Product>) this.repository.findAll();
        for(Product p : prods){

        }
        return prods;
    }

    public List<Product> findByName(String partialName){
        return (List<Product>) this.repository.findByNameContaining(partialName);
    }

    public Product findById(long id){
        return (Product) this.repository.findById(id);
    }

}
