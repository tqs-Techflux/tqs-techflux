package tqs.marketplace.services;

import org.springframework.stereotype.Service;
import tqs.marketplace.entities.Category;
import tqs.marketplace.entities.Product;
import tqs.marketplace.repositories.CategoryRepository;
import tqs.marketplace.repositories.ProductRepository;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository repository;
    private ProductRepository productRepository;

    protected CategoryService(){}

    public CategoryService(CategoryRepository repository, ProductRepository productRepository){
        this.repository = repository;
        this.productRepository = productRepository;
        this.saveCategories();
    }

    public boolean saveCategories() {
        // save a few categories
        this.repository.save(new Category("Components"));
        this.repository.save(new Category("Computers"));
        this.repository.save(new Category("Mobile Devices"));
        return true;
    }

    public boolean createCategory(String categoryName){
        this.repository.save(new Category(categoryName));
        return true;
    }

    public List<Category> findAll(){
        return (List<Category>) repository.findAll();
    }

    public Category findByName(String categoryName){
        return (Category) repository.findByName(categoryName);
    }

    public Category findById(long categoryId){
        return (Category) repository.findById(categoryId);
    }

    public List<Product> findByProductsByCatName(String categoryName){
        return (List<Product>) productRepository.findByCategoryName(categoryName);
    }

    public List<Product> findByProductsByCatId(long categoryId){
        return (List<Product>) productRepository.findByCategoryId(categoryId);
    }


}
