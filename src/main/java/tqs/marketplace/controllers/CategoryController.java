package tqs.marketplace.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tqs.marketplace.entities.Category;
import tqs.marketplace.services.CategoryService;

import java.util.List;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> all(){
        return new ResponseEntity<List<Category>>(categoryService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<Category> search(@PathVariable("categoryName") String categoryName) {
        return new ResponseEntity<Category>(categoryService.getCategory(categoryName), HttpStatus.OK);
    }

}
