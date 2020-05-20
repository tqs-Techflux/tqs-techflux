package tqs.marketplace.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tqs.marketplace.entities.Product;
import tqs.marketplace.services.ProductService;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> search(){
        return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/q={productName}")
    public ResponseEntity<List<Product>> searchByName(@PathVariable("productName") String productName){
        return new ResponseEntity<List<Product>>(productService.findByName(productName), HttpStatus.OK);
    }

    @GetMapping("/id={productId}")
    public ResponseEntity<Product> searchById(@PathVariable("productId") long productId){
        return new ResponseEntity<Product>(productService.findById(productId), HttpStatus.OK);
    }

    @GetMapping("/id={productId}/img")
    public ResponseEntity<byte[]> getPicture(@PathVariable("productId") long productId) throws IOException {
        Product p = productService.findById(productId);
        String filepath = p.getPicturePath();
        File img = new File(filepath);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(Files.readAllBytes(img.toPath()));
    }

}
