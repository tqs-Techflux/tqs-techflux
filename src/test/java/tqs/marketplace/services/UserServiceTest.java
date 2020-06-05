package tqs.marketplace.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import tqs.marketplace.entities.User;
import tqs.marketplace.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @MockBean
    private UserService service;

    @MockBean
    private UserRepository repository;
    @MockBean
    private CredentialService cs;

    @BeforeEach
    void setUp(){
        this.service = new UserService();
    }

    @Test
    void saveUsersTest() {
        service.saveUsers();
        assertEquals("joaoaz@gmail.com", service.loadUserByEmail("joaoaz@gmail.com").getEmail());
    }

    @Test
    void saveUser() {
        String testfName = "testfName";
        String testlName = "testlName";
        String testEmail = "testEmail@mail.com";
        String testContact = "123456789";
        String testPassword = "testPassword";
        service.saveUser(testfName, testlName, testEmail, testContact, testPassword);
        assertTrue(service.findByName(testfName).size() == 1);
    }

    @Test
    void updateUserTest() {
        String testfName = "testfName";
        String testlName = "testlName";
        String testEmail = "testEmail@mail.com";
        String testContact = "123456789";
        String testPassword = "testPassword";
        service.saveUser(testfName, testlName, testEmail, testContact, testPassword);
        String newContact = "987654321";
        User resultUser = service.updateUser("testEmail@mail.com", "", "", "", "");
        assertEquals(newContact, resultUser.getContact());
    }

    @Test
    void loadUserByEmail() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findById() {
    }
}