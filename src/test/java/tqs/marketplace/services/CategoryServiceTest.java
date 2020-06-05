package tqs.marketplace.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import tqs.marketplace.entities.Category;
import tqs.marketplace.repositories.CategoryRepository;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    @MockBean
    private CategoryService service;

    @BeforeEach
    void setUp(){
        this.service = new CategoryService();
    }

    @Test
    void CreateAndSaveCategoriesTest() {
        String testCategory = "Mobile";
        service.createCategory(testCategory);
        assertEquals(testCategory, service.findByName(testCategory).getName());
    }

    @Test
    void SaveCategoriesTest(){
        service.saveCategories();
        assertEquals("Components", service.findByName("Components").getName());
        assertEquals("Computers", service.findByName("Computers").getName());
        assertEquals("Computers", service.findByName("Computers").getName());
    }


    @Test
    void getAllTest() {
        String categoryNameTest = "TV";
        Category categoryTest = new Category(categoryNameTest);
        service.createCategory(categoryNameTest);
        assertTrue(service.findAll().contains(categoryTest));
    }

    @Test
    void AttemptToAddAnAlreadyExistingCategoryTest(){
        fail();
    }

    @Test
    void GetCategoryWhenNoCategoriesExistTest(){
        fail();
    }

}
