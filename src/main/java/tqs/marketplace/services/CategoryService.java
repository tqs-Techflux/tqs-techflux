package tqs.marketplace.services;

import org.springframework.stereotype.Service;
import tqs.marketplace.entities.Category;
import tqs.marketplace.repositories.CategoryRepository;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository categoryRepository){
        this.repository = categoryRepository;
        this.saveCategories();
    }

    public boolean saveCategories() {
        // save a few categories
        this.repository.save(new Category("components"));
        this.repository.save(new Category("computers"));
        this.repository.save(new Category("mobile_devices"));

        return true;
    }

    public boolean createCategory(String categoryName){
        this.repository.save(new Category(categoryName));
        return true;
    }

    public Category getCategory(String categoryName){
        Category category = repository.findByName(categoryName);
        return category;
    }


}
