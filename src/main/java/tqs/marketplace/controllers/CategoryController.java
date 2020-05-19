package tqs.marketplace.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tqs.marketplace.entities.Category;
import tqs.marketplace.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<Category> search(@PathVariable("categoryName") String categoryName) {
        return new ResponseEntity<Category>(categoryService.getCategory(categoryName), HttpStatus.OK);
    }

}
