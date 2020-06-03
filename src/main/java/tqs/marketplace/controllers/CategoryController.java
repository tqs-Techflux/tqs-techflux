package tqs.marketplace.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tqs.marketplace.entities.Category;
import tqs.marketplace.entities.Product;
import tqs.marketplace.services.CategoryService;

import java.util.List;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;

    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> all(){
        return new ResponseEntity<List<Category>>(categoryService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<Product>> search(@PathVariable("categoryName") String categoryName) {
        return new ResponseEntity<List<Product>>(categoryService.findByProductsByCatName(categoryName), HttpStatus.OK);
    }

    @GetMapping("/id/{categoryId}")
    public ResponseEntity<List<Product>> search(@PathVariable("categoryId") int categoryId) {
        return new ResponseEntity<List<Product>>(categoryService.findByProductsByCatId(categoryId), HttpStatus.OK);
    }

}
