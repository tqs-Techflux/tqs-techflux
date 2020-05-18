package tqs.marketplace.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tqs.marketplace.entities.Product;
import tqs.marketplace.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<Product> search(){
        return productService.search();
    }

    @GetMapping("/{productName}")
    public ResponseEntity<Product> search(@PathVariable("productName") String productName){
        return productService.search(productName);
    }

}
