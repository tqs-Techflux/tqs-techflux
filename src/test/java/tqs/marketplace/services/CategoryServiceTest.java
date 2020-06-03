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


    @Test
    void CreateAndSaveCategoriesTest() {
        String testCategory = "Mobile";
        service.createCategory(testCategory);
        assertEquals(testCategory, service.getCategory(testCategory).getCategoryName());
    }

    @Test
    void SaveCategoriesTest(){
        service.saveCategories();
        assertEquals("Components", service.getCategory("Components").getCategoryName());
        assertEquals("Computers", service.getCategory("Computers").getCategoryName());
        assertEquals("Mobile Devices", service.getCategory("Mobile Devices").getCategoryName());
    }


    @Test
    void getAllTest() {
        String categoryNameTest = "TV";
        Category categoryTest = new Category(categoryNameTest);
        service.createCategory(categoryNameTest);
        assertTrue(service.getAll().contains(categoryTest));
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