package tqs.marketplace.controllers;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tqs.marketplace.entities.Product;
import tqs.marketplace.services.ProductService;


import javax.servlet.ServletContext;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ResourceLoader resourceLoader;

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
        this.productService.saveProducts();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> search(){
        return new ResponseEntity<List<Product>>(this.productService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/image/{productId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getPic(@PathVariable("productId") long productId) throws IOException{
        try{
            InputStream in = this.resourceLoader.getResource("classpath:pictures/"+productId).getInputStream();
            return IOUtils.toByteArray(in);
        } catch (FileNotFoundException e){
            return null;
        }
    }

    @GetMapping("/query/{productName}")
    public ResponseEntity<List<Product>> searchByName(@PathVariable("productName") String productName){
        return new ResponseEntity<List<Product>>(productService.findByName(productName), HttpStatus.OK);
    }

    @GetMapping("/id/{productId}")
    public ResponseEntity<Product> searchById(@PathVariable("productId") long productId){
        return new ResponseEntity<Product>(productService.findById(productId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(String productName, String description, double price, MultipartFile picture, long ownerId, String catName) throws IOException {
        Product p = productService.saveProduct(
                productName,
                description,
                price,
                null,
                ownerId,
                catName);
        String realPath = this.productService.saveFile(picture,Long.toString(p.getId()));
        p.setPicture(realPath);
        p = this.productService.saveProduct(p);
        return new ResponseEntity<Product>(p,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateProduct(long id, String productName, String description, double price, String picturePath){
        return new ResponseEntity<Boolean>(productService.updateProduct(
                id,
                productName,
                description,
                price,
                picturePath
        ), HttpStatus.OK);
    }

}
