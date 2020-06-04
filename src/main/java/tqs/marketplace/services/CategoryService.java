package tqs.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tqs.marketplace.entities.Category;
import tqs.marketplace.entities.Product;
import tqs.marketplace.repositories.CategoryRepository;
import tqs.marketplace.repositories.ProductRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ProductRepository productRepository;

    public boolean saveCategories() {
        // save a few categories
        createCategory("Components");
        createCategory("Computers");
        createCategory("Mobile Devices");
        return true;
    }

    public boolean createCategory(String categoryName){
        this.repository.save(new Category(categoryName));
        return true;
    }

    public List<Category> findAll(){
        return (List<Category>) this.repository.findAll();
    }

    public Category findByName(String categoryName){
        return (Category) this.repository.findByName(categoryName);
    }

    public Category findById(long categoryId){
        return (Category) this.repository.findById(categoryId);
    }

    public List<Product> findByProductsByCatName(String categoryName){
        return (List<Product>) productRepository.findByCategoryName(categoryName);
    }

    public List<Product> findByProductsByCatId(long categoryId){
        return (List<Product>) productRepository.findByCategoryId(categoryId);
    }


}
