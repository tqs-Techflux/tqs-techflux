package tqs.marketplace.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import tqs.marketplace.entities.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @MockBean
    private ProductService service;

    @Test
    void ProductListIsEmptyAtStartTest(){
        assertTrue(service.findAll().isEmpty());
    }

    @Test
    void CreateAndSaveNewProductWithoutPicturePathTest(){
        String testName = "Prototype Product";
        String testDescription = "Prototype Product for testing";
        double testPrice = 99.99;
        Product testProduct = new Product(testName, testDescription, testPrice);
        service.saveProduct(testName, testDescription, testPrice);
        assertTrue(service.findByName(testName).contains(testProduct));
        assertTrue(service.findAll().size() == 1);
    }

    @Test
    void CreateAndSaveNewProductWithPicturePathTest(){
        String testName = "Prototype Product";
        String testDescription = "Prototype Product for testing";
        double testPrice = 99.99;
        String testPicPath = "https://lunawood.com/wp-content/uploads/2018/02/placeholder-image.png";
        Product testProduct = new Product(testName, testDescription, testPrice, testPicPath);
        service.saveProduct(testName, testDescription, testPrice, testPicPath);
        assertTrue(service.findByName(testName).contains(testProduct));
        assertTrue(service.findAll().size() == 1);
    }

    @Test
    void findProductByIDTest(){
        String testName = "Prototype Product";
        String testDescription = "Prototype Product for testing";
        double testPrice = 99.99;
        String testPicPath = "https://lunawood.com/wp-content/uploads/2018/02/placeholder-image.png";
        service.saveProduct(testName, testDescription, testPrice, testPicPath);
        assertEquals(0, service.findById(1).getId());
    }

    @Test
    void addingTwoEqualProductsTest(){
        String testName = "Prototype Product";
        String testDescription = "Prototype Product for testing";
        double testPrice = 99.99;
        String testPicPath = "https://lunawood.com/wp-content/uploads/2018/02/placeholder-image.png";
        service.saveProduct(testName, testDescription, testPrice, testPicPath);
        service.saveProduct(testName, testDescription, testPrice, testPicPath);
        assertTrue(service.findAll().size() < 2);
    }


}