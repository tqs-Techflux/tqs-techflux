package tqs.marketplace.services;

import org.springframework.stereotype.Service;
import tqs.marketplace.entities.Category;
import tqs.marketplace.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository){
        this.repository = repository;
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

    public List<Category> getAll(){
        return (List<Category>) repository.findAll();
    }

    public Category getCategoryByName(String categoryName){
        Category category = repository.findByName(categoryName);
        return category;
    }

    public Category getCategoryById(int categoryId){
        Category category = repository.findById(categoryId);
        return category;
    }


}
