package tqs.marketplace.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import tqs.marketplace.entities.Category;
import tqs.marketplace.entities.Product;
import tqs.marketplace.entities.User;
import tqs.marketplace.repositories.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {


    @MockBean
    private ProductRepository repository;
    @MockBean
    private CategoryService cs;
    @MockBean
    private UserService us;
    @MockBean
    private TransactionService ts;

    @MockBean
    private ProductService service;

    @BeforeEach
    void setUp(){
        this.service = new ProductService();
    }


    @Test
    void ProductListIsEmptyAtStartTest(){
        assertTrue(service.findAll().isEmpty());
    }

    @Test
    void CreateAndSaveNewProductTest(){
        service.saveProducts();
        assertFalse(service.findAll().isEmpty());
    }


    @Test
    void CreateAndSaveNewProductWithOwnerAndCategoryNameTest(){
        String testName = "Prototype Product";
        String testDescription = "Prototype Product for testing";
        double testPrice = 99.99;
        String testPicPath = "https://lunawood.com/wp-content/uploads/2018/02/placeholder-image.png";
        User testOwner = us.loadUserByEmail("joaoaz@gmail.com");
        Category testCategory = cs.findByName("Components");
        Product testProduct = new Product(testName, testDescription, testPrice, testPicPath, testOwner, testCategory);
        service.saveProduct(testProduct);
        assertTrue(service.findByName(testName).contains(testProduct));
        assertTrue(service.findAll().size() >= 1);
    }

    @Test
    void CreateAndSaveNewProductWithOwnerAndCategoryIDTest(){
        String testName = "Prototype Product";
        String testDescription = "Prototype Product for testing";
        double testPrice = 99.99;
        String testPicPath = "https://lunawood.com/wp-content/uploads/2018/02/placeholder-image.png";
        User testOwner = us.loadUserByEmail("joaoaz@gmail.com");
        Category testCategory = cs.findById(0);
        Product testProduct = new Product(testName, testDescription, testPrice, testPicPath, testOwner, testCategory);
        service.saveProduct(testProduct);
        assertTrue(service.findByName(testName).contains(testProduct));
        assertTrue(service.findAll().size() >= 1);
    }


    @Test
    void findProductByNameTest(){
        String testName = "Prototype Product";
        String testDescription = "Prototype Product for testing";
        double testPrice = 99.99;
        String testPicPath = "https://lunawood.com/wp-content/uploads/2018/02/placeholder-image.png";
        User testOwner = us.loadUserByEmail("joaoaz@gmail.com");
        Category testCategory = cs.findById(0);
        Product testProduct = new Product(testName, testDescription, testPrice, testPicPath, testOwner, testCategory);
        service.saveProduct(testProduct);

        assertTrue( service.findByName(testName).contains(testProduct));
    }


    @Test
    void findProductByIDTest(){
        String testName = "Prototype Product";
        String testDescription = "Prototype Product for testing";
        double testPrice = 99.99;
        String testPicPath = "https://lunawood.com/wp-content/uploads/2018/02/placeholder-image.png";
        User testOwner = us.loadUserByEmail("joaoaz@gmail.com");
        Category testCategory = cs.findById(0);
        Product testProduct = new Product(testName, testDescription, testPrice, testPicPath, testOwner, testCategory);
        service.saveProduct(testProduct);

        assertEquals(0, service.findById(0).getId());
    }


}
